package others;

import java.util.Date;

public class Fulfillment {
    public static void main(String[] args) {

        System.out.println(new Date());

        long start_order_id = 628152714608954231L;
        int step = 1;

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % 1000;
            String orders = "insert orders_0 (id, order_sn, pay_status, group_status, status, goods_amount, order_amount, order_time, uid, mall_id, group_id, group_order_id, pay_time, pay_app_id) values(" + order_id + ", " + order_sn + ", 2, 0, 1, 100, 100, 2019-01-01, 1, 1, 1, 1, 2019-01-01, 1);";
            System.out.println(orders);
        }

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            String orderExt = "insert order_extension_0 (order_id, promise_shipping_time) values(" + order_id + ", 2019-01-01);";
            System.out.println(orderExt);
        }

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            String updateOrders = "update orders_0 set order_status = 1, group_status = 1, status = 2, confirm_time = 1 where id = " + order_id + ";";
            System.out.println(updateOrders);
        }

        System.out.println();

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % 1000;
            String fulfillment = "insert into fulfillment_0(order_sn, promise_shipping_time, status) values(" + order_sn + ", 2019-01-01, 1);";
            System.out.println(fulfillment);
        }

    }
}
