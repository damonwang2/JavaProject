package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/9.
 */
import java.util.*;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int length = array.length;
        if(length == 0)
            return;
        int[] copyOf=Arrays.copyOf(array, length);
        int index = 0;
        for(int num : copyOf){
            //是奇数
            if((num & 1) != 0)
                array[index++] = num;
        }
        for(int num : copyOf){
            //是奇数
            if((num & 1) == 0)
                array[index++] = num;
        }
    }
}

