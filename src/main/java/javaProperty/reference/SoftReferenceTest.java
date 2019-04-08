package javaProperty.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {

    public static int M = StrongReferenceTest.M;

    public static void main(String[] args){
        StrongReferenceTest.printlnMemory("1.原可用内存和总内存");

        //建立软引用
        SoftReference<Object> softReference =
                new SoftReference<>(new byte[10*SoftReferenceTest.M]);
        StrongReferenceTest.printlnMemory("2.实例化10M的数组,并建立软引用");
        System.out.println("softReference.get() : "+softReference.get());

        System.gc();
        StrongReferenceTest.printlnMemory("3.内存可用容量充足，GC后");
        System.out.println("softReference.get() : "+softReference.get());

        //实例化一个4M的数组,使内存不够用,并建立软引用
        //free=10M=4M+10M-4M,证明内存可用量不足时，GC后byte[10*m]被回收
        SoftReference<Object> softReference2 =
                new SoftReference<>(new byte[4*SoftReferenceTest.M]);
        StrongReferenceTest.printlnMemory("4.实例化一个4M的数组后");
        System.out.println("softReference.get() : "+softReference.get());
        System.out.println("softReference2.get() : "+softReference2.get());
    }
}