package javaProperty.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by pojun on 2019/1/14.
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 创建中介类实例
        DynamicProxy inter = new DynamicProxy(new Vendor());
        // 加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        // 去掉也可以，why？
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 获取代理类实例sell
        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));

//        sell = (Sell)Proxy.getProxyClass(Sell.class.getClassLoader(), Sell.class);

        // 通过代理类对象调用代理类方法，实际上会转到invoke方法调用
        sell.sell();
        sell.ad();

        System.out.println("getName:" + sell.getClass().getName());
    }
}
