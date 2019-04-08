package oj.jianzhiOffer;
import java.util.*;
/**
 * Created by Damon on 2017/7/13.
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        int[] a = {4,8,6,12,16,14,10};
        System.out.println(Arrays.asList(a));
        System.out.println( v.VerifySquenceOfBST(a) );
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        return help(sequence, 0, len-1);
    }

    public boolean help(int[] sequence, int start, int end){
        if(start == end)
            return true;
        int root = sequence[end];
        int i = start;

        //i对应的是右子树部分,end对应根节点部分
        for( ; i < end; i++){
            if(sequence[i] > root)
                break;
        }

        for(int j = i; j < end; j++){
            if(sequence[j] < root)
                return false;
        }

        boolean left = true;
        //如果i等于start，表示没有左子树，不用判断
        if(i > start)
            left = help(sequence, start, i-1);

        boolean right = true;
        //如果i等于end，则表示没有右子树，不用判断
        if(i < end)
            right = help(sequence, i, end-1);

        return (left&&right);
    }
}
