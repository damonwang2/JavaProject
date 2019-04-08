package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/9.
 */

import java.util.Arrays;
import java.util.regex.*;

public class IsNumeric {

    public static void main(String[] args) {
        Pattern p=Pattern.compile("\\d+");
        String[] str = p.split("我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
        //字符数组转String用String.valueOf(char[])
        //数组转ArrayList用Arrays.asList(str[])
        System.out.println(Arrays.asList(str));
        System.out.println("-------------------");
        char[] chars = "string".toCharArray();
        for(char c : chars){
            System.out.println(c);
        }
    }

    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[+-]?\\d*(\\.\\d*)?([Ee][+-]?\\d+)?");
    }
}
