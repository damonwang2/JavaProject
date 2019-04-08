package onlineExamination.pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int count = n;

        Bun[] buns = new Bun[n];
        for(int i = 0; i < n; i++){
            buns[i] = new Bun(i, in.nextInt(), in.nextInt());
        }

        //根据degree和degreeDeclined排序
        Comparator<Bun> c1 = new Comparator<Bun>() {
            @Override
            public int compare(Bun bun1, Bun bun2) {
                if(bun1.degree != bun2.degree){
                    return bun2.degree - bun1.degree;
                }
                return bun2.degreeDeclined - bun1.degreeDeclined;
            }
        };

        Arrays.sort(buns, c1);

        while(buns[0].degree > 0){
            //每天吃两个，置为-1表示已经吃了
            buns[0].degree = -1;
            count--;

            if(buns[1].degree > 0){
                buns[1].degree = -1;
                count--;
            }

            //每天美味度减少
            for(int i = 0; i < n; i++){
                //对没有吃过的包子减少美味度
                if(buns[i].degree > 0){
                    //如果美味度减少为负数，则不需要继续减少
                    if(buns[i].degree > buns[i].degreeDeclined){
                        buns[i].degree -= buns[i].degreeDeclined;
                    }else {
                        buns[i].degree = 0;
                        count--;
                    }
                }
            }

            //检查
            if(count < m){
                break;
            }

            //排序
            Arrays.sort(buns, c1);
        }

        Arrays.sort(buns, new Comparator<Bun>() {
            @Override
            public int compare(Bun o1, Bun o2) {
                return o1.id - o2.id;
            }
        });

        for(int i = 0; i < n; i++){
            System.out.println(buns[i].degree);
        }
    }
}

class Bun{
    int id;
    int degree;
    int degreeDeclined;

    public Bun(int id, int degree, int degreeDeclined){
        this.id = id;
        this.degree = degree;
        this.degreeDeclined = degreeDeclined;
    }
}