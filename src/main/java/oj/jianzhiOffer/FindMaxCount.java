package oj.jianzhiOffer;

import java.util.*;

public class FindMaxCount {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,143,1,2,2,3,1};
        int[] array1 = {1,2,3,5,143,1,2,2,3,2};

        FindMaxCount object = new FindMaxCount();
        System.out.println(object.findMaxCount(array));
        System.out.println(object.findMaxCount(array1));
        System.out.println(25 / 10);
    }

    public int findMaxCount(int[] array){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 0;
        List<Integer> list = new ArrayList<Integer>();

        for(Integer i : array){
            //判断是否记录过
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                //第一次出现，次数记为1
                map.put(i, 1);
            }

            //如果频率更大，则清空list数组再添加
            if(map.get(i) > maxCount){
                list.clear();
                list.add(i);
                maxCount = map.get(i);
            }else if(map.get(i) == maxCount){
                //如果频率相同，添加
                list.add(i);
            }
        }
        //如果有多个值频率相同，返回-1
        if(list.size() > 1)
            return -1;
        return list.get(0);
    }
}