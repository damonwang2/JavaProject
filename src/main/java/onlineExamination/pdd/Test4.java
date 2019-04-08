package onlineExamination.pdd;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        Pos[] valuesPlus = new Pos[n];
        Pos[] valuesSub = new Pos[n];

        //输入
        for(int i = 0; i < n; i++){
            values[i] = in.nextInt();
            valuesPlus[i] = new Pos(i, values[i] + i);
            valuesSub[i] = new Pos(i, values[i] - i);
        }

        //排序
        Comparator<Pos> c = new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.value - o2.value;
            }
        };
        Arrays.sort(valuesPlus, c);
        Arrays.sort(valuesSub, c);

        int max = 0;
        int count = 0;

        //上下选出50个



        for(int i = 0; i < 50 && i < n; i++){
            for(int j = n-1; j >= n-50 && j >= 0; j--){
                if(i < j){
                    int curValue = valuesPlus[j].value + valuesSub[i].value;
                    int indexJ = valuesPlus[j].index;
                    int indexI = valuesSub[i].index;

                    if(indexJ - indexI > (n + indexI - indexJ)){
                        curValue = curValue - (indexJ - indexI) + (n + indexI - indexJ);
                    }

                    if(curValue > max){
                        max = curValue;
                        count = 1;
                        System.out.println(indexI);
                        System.out.println(indexJ);
                    }else if(curValue == max){
                        count++;
                    }
                }
            }
        }

        System.out.println(max);

        System.out.println(count);
    }
}
class Pos{
    int index;
    int value;
    public Pos(int index, int value){
        this.index = index;
        this.value = value;
    }
}
