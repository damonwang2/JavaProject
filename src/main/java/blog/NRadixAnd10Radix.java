package blog;

public class NRadixAnd10Radix {
    public static void main(String[] args) {
        String s = "ABC";
        int i = Integer.parseInt(s, 16);
        int j = Integer.valueOf(s, 16);

        System.out.println(i);
        System.out.println(j);

        String s1 = Integer.toString(i, 16);
        System.out.println(s1);
    }
}
