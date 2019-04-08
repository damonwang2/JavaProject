package javaProperty.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicClient {

    public static void main(String args[]){
        //要代理的真实对象
        ICoder coder = new JavaCoder("Zhang");
        //创建中介类实例
        InvocationHandler  handler = new CoderDynamicProxy(coder);
        //获取类加载器
        ClassLoader cl = coder.getClass().getClassLoader();
        //动态产生一个代理类
        ICoder proxy = (ICoder) Proxy.newProxyInstance(cl, coder.getClass().getInterfaces(), handler);
        //通过代理类，执行doSomething方法；
        proxy.implDemands("Modify user management");
    }
}

class CoderDynamicProxy implements InvocationHandler {
    //被代理的实例
    private ICoder coder;

    public CoderDynamicProxy(ICoder _coder){
        this.coder = _coder;
    }

    //调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(coder, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }
}

class JavaCoder implements ICoder{

    private String name;

    public JavaCoder(String name){
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(name + " implemented demand:" + demandName + " in JAVA!");
    }
}

interface ICoder {

    public void implDemands(String demandName);

}