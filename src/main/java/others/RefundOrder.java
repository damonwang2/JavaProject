package others;

/**
 * @author pojun on 2019/3/12
 */
public class RefundOrder {
    public static void main(String[] args) {
        long start_order_id = 628152714608957323L;
        String order_sn_prefix = "190108-21952987151";
        int step = 1;
        int mod = 10000;

        // 下单
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            String order_sn_suffix = String.valueOf(order_id % mod);
            String order_sn = "'" + order_sn_prefix + order_sn_suffix + "'";
            String orders = "insert refund_order_0(id, order_sn, refund_sn, transaction_id, caiwu_time, status) values(" +
                order_id + ", " + order_sn + ", " + order_sn_suffix  + ", " + order_sn_suffix  + ", 1, 9);";
            System.out.println(orders);

            String orderExt = "update refund_order_0 set status = 4, refund_time = 1 where order_sn = " + order_sn + ";";
            System.out.println(orderExt);
        }

    }
}
