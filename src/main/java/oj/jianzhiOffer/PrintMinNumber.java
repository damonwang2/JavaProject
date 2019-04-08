package oj.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Damon on 2017/7/17.
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        PrintMinNumber ins = new PrintMinNumber();

        System.out.println(ins.PrintMinNumber(a));
    }

    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<String>();
        for(int num : numbers){
            list.add(num+"");
            //Integer.toString(num);
            //String.valueOf(num)
        }

        //排序
        Collections.sort(list, c);

        StringBuffer res = new StringBuffer();
        for (String str: list) {
            res.append(str);
        }

        return res.toString();
    }

    static Comparator<String> c = new Comparator(){
        public int compare(Object num1, Object num2) {
            String a = (String)num1;
            String b = (String)num2;
            return (a+b).compareTo(b+a);
        }
    };
}
