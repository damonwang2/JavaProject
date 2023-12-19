package dataStructureAndAlgorithm;

public class KMP {
    public static void main(String[] args) {
        String pattern = "abcac";
        String source = "ababcabcacbab";

        int[] next = getNext(pattern);

        for (int i : next){
            System.out.print(i + " ");
        }
        System.out.println();

        int count = 0;
        for(int i = 0, j = 0; i < source.length() && j < pattern.length(); ){
            System.out.println("i=" + i +"，j=" + j);
            count++;
            if(j < 0 || source.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
            if(j == pattern.length()){

                System.out.println(count);
                System.out.println("success, the first position in source is " + (i-pattern.length()));
                return;
            }
        }
        System.out.println(count);
    }

    public static int[] getNext(String pattern){
        int length = pattern.length();
        int[] next = new int[length];
        next[0] = -1;

        for (int i = 1, j = 0; i < length - 1;){
            if(j < 0 || pattern.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }

        return next;
    }
}
