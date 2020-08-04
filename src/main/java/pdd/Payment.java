package pdd;

import java.util.Date;

public class Payment {
    public static void main(String[] args) {

        System.out.println(new Date());

        long startOrderId = 628152714608958433L;
        String orderSnPrefix = "190108-21952987151";
        int step = 1;
        int mod = 10000;
        // 确认收货
        for (int i = 0; i < step; i++) {
            long orderId = startOrderId + i;
            long orderSn = orderId % mod;
            String orders =
                "insert orders_0 (id, order_sn, order_status, pay_status, group_status, shipping_status, status, goods_amount, " +
                    "order_amount, order_time, uid, mall_id, group_id, group_order_id, pay_app_id, pay_time, confirm_time) values(" +
                    orderId + ", " + "'" + orderSnPrefix + orderSn + "', 1, 2, 1, 0, 2, 100, 100, 1514736001, "
                    + orderId + ", 1, 1, 1, 1, 20190101, 20190101);";
            System.out.println(orders);

            String updateOrders =
                "update orders_0 set order_status = 1, pay_status = 2, group_status = 1, shipping_status = 2, status = 4, confirm_time = 1, receive_time = 1558088401 where id = "
                    + orderId + ";";
            System.out.println(updateOrders);
        }
    }
}
