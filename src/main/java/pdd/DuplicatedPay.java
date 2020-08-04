package pdd;

/**
 * @author pojun on 2019/3/12
 */
public class DuplicatedPay {
    public static void main(String[] args) {
        long start_order_id = 628152714608957322L;
        String order_sn_prefix = "190108-21952987151";
        int step = 1;
        int mod = 10000;

        // 下单
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % mod;
            String orders = "insert orders_0 (id, order_sn, order_status, pay_status, group_status, status, goods_amount, " +
                "order_amount, order_time, uid, mall_id, group_id, group_order_id, pay_app_id, pay_time) values(" +
                order_id + ", " + "'" + order_sn_prefix + order_sn + "', 0, 0, 99, 0, 100, 100, '2019-01-01', " + order_id % 1000 + ", 1, 1, 1, 1, 0);";
            System.out.println(orders);

            String orderExt = "insert order_extension_0 (order_id) values(" +
                order_id + ");";
            System.out.println(orderExt);
        }

        // 支付
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long transaction_id = order_id % mod;
            long order_sn = order_id % mod;
            String orderExt_update = "update order_extension_0 set transaction_id = " + transaction_id + " where order_id = " + order_id + ";";
            String order_update = "update orders_0 set order_status = " + 2 + " where id = " + order_id + ";";
            System.out.println(orderExt_update);
            System.out.println(order_update);

            System.out.println();

            String duplicated_pay = "insert duplicate_pay_refund(refund_sn, order_sn, transaction_id, status) values(" +
                transaction_id + ", '" + order_sn_prefix + order_sn + "', " + (transaction_id + 1000) + ", 1);";
            System.out.println(duplicated_pay);

            String update_duplicated_pay = "update duplicate_pay_refund set status = 4 where refund_sn = " + transaction_id + ";";
            System.out.println(update_duplicated_pay);
        }

    }
}
