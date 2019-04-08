package oj.jianzhiOffer;

/**
 * Created by Damon on 2017/7/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class S2{
    int x;
    int y;
    S2(int x, int y){
        this.x = x;
        this.y = y;
    }
    //重写toStirng方法，改变println时的显示效果
    public String toString(){
        return "("+x+", "+y+")";
    }
}

public class Sort2 {
    public static void main(String[] args) {
        List<S2> s2Set = new ArrayList<S2>();
        S2 s1 = new S2(3,5);
        S2 s2 = new S2(4,5);
        S2 s3 = new S2(4,2);
        s2Set.add(s1);
        s2Set.add(s2);
        s2Set.add(s3);
        //对容器进行排序的函数
        Collections.sort(s2Set,c);
        Iterator it = s2Set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
    static Comparator<S2> c = new Comparator(){
        public int compare(Object a0, Object a1) {
            S2 s1 = (S2) a0;
            S2 s2 = (S2) a1;
            if(s1.x != s2.x)
            {
                return s1.x - s2.x;
            }
            else
            {
                return s1.y - s2.y;
            }
        }
    };

}