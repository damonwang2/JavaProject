package javaProperty.proxy;

/**
 * Created by pojun on 2019/1/14.
 */
public class Vendor implements Sell {
    public void sell() {
        System.out.println("sell method");
    }

    public void ad() {
        System.out.println("ad method");
    }
}

interface Sell {
    void sell();
    void ad();
}
