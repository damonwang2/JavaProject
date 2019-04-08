package oj.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Damon on 2017/7/19.
 */
public class maxInWindows {

    public static void main(String[] args) {







        maxInWindows object = new maxInWindows();

        System.out.println();
    }

    public ArrayList<Integer> maxInWindows(int [] nums, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        //特殊情况
        if(nums == null || nums.length == 0 || k == 0)
            return res;

        //Java创建最大堆(优先队列)，
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());


        for(int i = 0; i < nums.length; i++){
            // 把窗口最左边的数去掉,时间复杂度为Lgk。i<k添加。i>=k,加一个删一个。
            if(i >= k)
                pq.remove(nums[i - k]);
            pq.add(nums[i]);

            // 堆顶就是窗口的最大值
            if(i + 1 >= k)
                res.add( pq.peek() );
        }

        return res;
    }
}
