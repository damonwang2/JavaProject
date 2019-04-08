package oj.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Damon on 2017/7/19.
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation object = new Permutation();
        String str = "abc";
        System.out.println(object.Permutation(str));
    }

    public ArrayList<String> Permutation(String str) {
       	ArrayList<String> result = new ArrayList<String>();
        if(str == null || str.length() == 0)
            return result;
        char[] chars = str.toCharArray();
        permuteRecursive(chars, 0, result);
        Collections.sort(result);
        return result;
    }

    public void permuteRecursive(char[] chars, int begin, ArrayList<String> result){
        if(begin >= chars.length){
            result.add(String.valueOf(chars));
            return;
        }
        for(int i = begin; i < chars.length; i++){
            swap(chars, begin, i);
            //交换下一个数
            permuteRecursive(chars, begin+1, result);
            swap(chars, begin, i);
        }
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //alt+insert插入方法
    @Override
    public String toString() {
        return "Permutation.toString()";
    }
}
