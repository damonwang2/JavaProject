package onlineExamination.meililianhe;

public class Main6048 {
    public static void main(String[] args) {
        long[] a = new long[51];

        a[0] = 0;
        a[1] = 1;

        for (int i = 2; i < a.length; i++) {
            a[i] = a[i-1] + a[i-2];
        }

        System.out.println(a[50]);
    }
}
