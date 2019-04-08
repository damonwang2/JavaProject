package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/17.
 */
public class StrToInt {

    public static void main(String[] args) {

    }

    public int StrToInt(String str) {
        int res;
        try {
            res = Integer.valueOf(str);
        }catch (Exception e){
            return 0;
        }
        return res;
    }
}
