package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.mortbay.util.ajax.JSON;

/**
 * TODO
 *
 * @author pojun
 * @date 2019/9/11
 */
public class GetOrderSn {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat().format(new Date()));
        Scanner in = new Scanner(System.in);
        Set<String> orderSnList = new HashSet<>();

        while (in.hasNext()) {
            String line = in.nextLine();
            String[] lines = line.split("(\"fulfillmentConfirm validate error, orderSn:)|(, effectiveTime:)");

            //String[] lines = line.split("orderSn:");
            orderSnList.add(lines[1].substring(0, 22));
        }

        for (String orderSn : orderSnList) {
            System.out.println(orderSn);
        }
    }
}