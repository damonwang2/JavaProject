package others;

import java.util.Date;

public class Payment {
    public static void main(String[] args) {

        System.out.println(new Date());

        long start_order_id = 628152714608957111L;
        String order_sn_prefix = "190108-21952987151";
        int step = 1;
        int mod = 10000;

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % mod;
            String orders = "insert orders_0 (id, order_sn, order_status, pay_status, group_status, status, goods_amount, " +
                    "order_amount, order_time, uid, mall_id, group_id, group_order_id, pay_app_id, pay_time) values(" +
                    order_id + ", " + "'" + order_sn_prefix + order_sn + "', 0, 0, 99, 0, 100, 100, 2019-01-01, 1, 1, 1, 1, 1, 0);";
            System.out.println(orders);

            String updateOrders = "update orders_0 set pay_status = 2, group_status = 0, status = 1, confirm_time = 1, pay_time = 2019-01-01 where id = " + order_id + ";";
            System.out.println(updateOrders);
        }

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long transaction_id = order_id % mod;
            String orderExt = "insert order_extension_0 (order_id) values(" +
                    order_id + ");";
            String orderExt_update = "update order_extension_0 set transaction_id = " + transaction_id + " where order_id = " + order_id + ";";
            System.out.println(orderExt);
            System.out.println(orderExt_update);
        }

        System.out.println();

        for (int i = 0; i < step; i++) {
            long order_id = start_order_id + i;
            long order_sn = order_id % mod;
            long transaction_id = order_id % mod;
            String fulfillment = "insert into payment_transaction_0(order_sn, outer_transaction_id, transaction_id, status, note) values('" + order_sn_prefix + order_sn + "', " + transaction_id + ", " + transaction_id + ", 0, 'pojun');";
            System.out.println(fulfillment);

            String fulfillment_update = "update payment_transaction_0 set status = 4 where transaction_id = " + transaction_id + ";";

            System.out.println(fulfillment_update);
        }

    }
}
