package pdd;

/**
 * @author pojun on 2019/3/12
 */
public class Ascrights {
    public static void main(String[] args) {
        long start_order_id = 628152714608957332L;
        String order_sn_prefix = "190108-21952987151";
        int step = 1;
        int mod = 10000;

        // 下单
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % mod;
            String ascrights = "insert newbee_insurance_priority_0 (uid, order_sn, mall_id, status) values" +
                "(1, '" + order_sn_prefix + order_sn + "', 1, 1);";
            System.out.println(ascrights);

            String ascrightsUpdate = "update newbee_insurance_priority_0 set status = 2 where order_sn = '" + order_sn_prefix + order_sn + "';";
            System.out.println(ascrightsUpdate);

            String orderExtra = "insert order_extra_0 (order_id, uid, field_type, field_value, mall_id, order_sn) values" +
                "(" + order_id + ", 1, 39, '{\"0\":\"1\"}', 1, '" + order_sn_prefix + order_sn + "');";
            System.out.println(orderExtra);
        }


    }
}
