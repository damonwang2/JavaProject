package javaProperty.singleton;

// 懒汉方式。指全局的单例实例在第一次被使用时构建，即使用Singleton.getInstance()创建
// 为什么叫懒汉，不到getInstance不创建
public class Singleton {
    //不能加final，因为final必须声明时初始化或者在构造函数中初始化
    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            // 这里必须锁类，对象还未初始化
            synchronized (Singleton.class) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }
}

// 饿汉方式。指全局的单例实例在类装载时构建， 因为final变量赋了初值，加载的时候会初始化
// 为什么叫饿汉，因为比较饥渴，还没到getInstance就创建了
//public class Singleton {
//    private static final Singleton INSTANCE = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return INSTANCE;
//    }
//}