package javaProperty.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static int M = StrongReferenceTest.M;

    public static void main(String[] args){
        StrongReferenceTest.printlnMemory("1.原可用内存和总内存");

        // 创建弱引用
        WeakReference<Object> weakReference = new WeakReference<>(new byte[10*M]);
        StrongReferenceTest.printlnMemory("2.实例化10M的数组,并建立弱引用");
        System.out.println("weakReference.get() : " + weakReference.get());

        System.gc();
        StrongReferenceTest.printlnMemory("3.GC后");
        System.out.println("weakReference.get() : " + weakReference.get());
    }
}
