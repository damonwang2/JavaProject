package pdd;

/**
 * @author pojun on 2019/3/12
 */
public class RefundOrder {

    private static long start_order_id = 628152714608957431L;
    private static String order_sn_prefix = "190108-21952987151";
    private static int step = 1;
    private static int mod = 10000;

    public static void main(String[] args) {
        refundCoupon();
    }

    // 退券
    private static void refundCoupon() {
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long return_coupon_id = order_id % mod;
            String order_sn_suffix = String.valueOf(return_coupon_id);
            String order_sn = "'" + order_sn_prefix + order_sn_suffix + "'";
            String orders = "insert refund_order_0(id, order_sn, refund_sn, transaction_id, caiwu_time, status, return_coupon_amount) values("
                + order_id + ", " + order_sn + ", " + order_sn_suffix + ", " + order_sn_suffix + ", 1, 9, 100);";
            System.out.println(orders);

            String orderExt = "update refund_order_0 set return_coupon_id = "
                + return_coupon_id + " where order_sn = " + order_sn + ";";
            System.out.println(orderExt);

            String coupon = "insert coupon_0(id, uid, mall_id, discount_amount) values (" + return_coupon_id
                + ", 1, 1, 100);";
            System.out.println(coupon);
        }
    }

    private static void refundSuccess() {
        // 下单
        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            String order_sn_suffix = String.valueOf(order_id % mod);
            String order_sn = "'" + order_sn_prefix + order_sn_suffix + "'";
            String orders = "insert refund_order_0(id, order_sn, refund_sn, transaction_id, caiwu_time, status) values("
                +
                order_id + ", " + order_sn + ", " + order_sn_suffix + ", " + order_sn_suffix + ", 1, 9);";
            System.out.println(orders);

            String orderExt = "update refund_order_0 set status = 4, refund_time = 1 where order_sn = " + order_sn
                + ";";
            System.out.println(orderExt);
        }
    }
}
