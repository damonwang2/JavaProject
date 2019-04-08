package javaProperty;

public class AutoBoxing {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 5;
        Integer f = 321;
        Integer g = 321;

        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(c == (a+b));

        System.out.println(f == g);
        System.out.println(f.equals(g));
        System.out.println(f.hashCode());
        System.out.println(g.hashCode());
        System.out.println((c+f) == (d+g));
    }
}
