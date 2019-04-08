package pdd;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by pojun on 2019/1/23.
 */
public class GetSchema {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

    // 业务域->连接
    private static Map<String, ConnectionMeta> business2connect = new TreeMap<>();

    // 业务域->数据表，后续考虑shard
    private static Map<String, List<String>> business2table = new TreeMap<>();

    // 不分表
    private static Set<String> tableWithoutShard = Sets.newHashSet("after_sale_play_money", "refund_freight",
            "ws_shop_balance_change", "stand_in_refund", "duplicate_pay_refund");

    static {
        // 胡桃街MySQL
        business2connect.put("order", new ConnectionMeta("jdbc:mysql://172.22.5.9:3306/olmeca_shard0", "order_rw", "order@pdd987"));
        business2table.put("order", Lists.newArrayList("orders", "order_goods", "order_extension", "step_pay_order"));

        business2connect.put("group", new ConnectionMeta("jdbc:mysql://172.22.5.9:3306/group_shard0", "order_rw", "order@pdd987"));
        business2table.put("group", Lists.newArrayList("group_orders", "group_member"));

        business2connect.put("fulfillment", new ConnectionMeta("jdbc:mysql://172.22.5.44:3306/express_fulfillment_0",
                "express_rw", "rp4yacRloyj5eWmv"));
        business2table.put("fulfillment", Lists.newArrayList("fulfillment", "service_template_cost"));

        business2connect.put("payment", new ConnectionMeta("jdbc:mysql://172.22.5.43:3306/payment_shard0",
                "payment_rw", "payment@pdd822"));
        business2table.put("payment", Lists.newArrayList("payment_transaction"));

        business2connect.put("payment2", new ConnectionMeta("jdbc:mysql://172.22.5.43:3306/payment_test", "payment_rw", "payment@pdd822"));
        business2table.put("payment2", Lists.newArrayList("transfer_transaction"));

        business2connect.put("payment3", new ConnectionMeta("jdbc:mysql://172.22.5.43:3306/pdd_finance", "payment_rw", "payment@pdd822"));
        business2table.put("payment3", Lists.newArrayList("ws_shop_balance_change"));

        business2connect.put("refund", new ConnectionMeta("jdbc:mysql://172.22.5.9:3306/refund_shard_0",
                "order_rw", "order@pdd987"));
        business2table.put("refund", Lists.newArrayList("refund_order"));

        business2connect.put("refund2", new ConnectionMeta("jdbc:mysql://172.22.5.9:3306/refund", "refund", "refund@pdd321"));
        business2table.put("refund2", Lists.newArrayList("refund_flow", "stand_in_refund", "duplicate_pay_refund"));

        business2connect.put("refund3", new ConnectionMeta("jdbc:mysql://172.22.5.43:3306/payment_refund_shard_0",
                "payment_rw", "payment@pdd822"));
        business2table.put("refund3", Lists.newArrayList("refund_transaction"));

        business2connect.put("afterSale", new ConnectionMeta("jdbc:mysql://172.22.5.8:3306/asm_shard_0",
                "order_asm_wr", "xUUZoU5j2szNTvQd"));
        business2table.put("afterSale", Lists.newArrayList("after_sales"));

        business2connect.put("afterSale2", new ConnectionMeta("jdbc:mysql://172.22.5.8:3306/pdd_asm", "order_asm_wr", "xUUZoU5j2szNTvQd"));
        business2table.put("afterSale2", Lists.newArrayList("after_sale_play_money","refund_freight"));

        business2connect.put("coupon", new ConnectionMeta("jdbc:mysql://172.22.5.12:3306/pernod_0", "promotion_rw", "promotion@pdd343"));
        business2table.put("coupon", Lists.newArrayList("coupon", "coupon_record"));

    }

    public static void main(String[] args) throws SQLException {
        // 连接MySQL，然后执行语句获取结果来处理即可
        for (Map.Entry<String, ConnectionMeta> stringConnectionMetaEntry: business2connect.entrySet()) {

            String business = stringConnectionMetaEntry.getKey();

            ConnectionMeta connectionMeta = stringConnectionMetaEntry.getValue();
            Connection connection = getConnection(connectionMeta);

            for (String logicalTable: business2table.get(business)) {

                if (CharUtils.isAsciiNumeric(business.charAt(business.length()-1))) {
                    System.out.println("business:" + business.substring(0, business.length()-1));
                } else {
                    System.out.println("business:" + business);
                }
                System.out.println(StringUtils.repeat("=", 100));

                String physicalTable = logicalTable;
                // 分表分库后的物理表
                if (!tableWithoutShard.contains(logicalTable)) {
                    physicalTable = logicalTable + "_0";
                }

                System.out.println("table:" + logicalTable);
                System.out.println(Schema.attributeFormat());

                String sql = "show full columns from " + physicalTable;
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                // 解析执行结果
                while (resultSet.next()) {
                    String field = resultSet.getString("field");
                    String isNull = resultSet.getString("null");
                    String isKey = resultSet.getString("key");
                    String extra = resultSet.getString("extra");
                    String comment = resultSet.getString("comment");
                    String type = resultSet.getString("type");

                    Schema schema = new Schema(field, type, isNull, isKey, extra, comment);
                    System.out.println(schema.format());
                }
                System.out.println(StringUtils.repeat("-", 100));
            }
        }
    }

    public static Connection getConnection(ConnectionMeta connectionMeta){
        Connection connection = null;
        try {
            //要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段。
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(connectionMeta.url, connectionMeta.user, connectionMeta.password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(connectionMeta);
        }
        return connection;
    }
}
