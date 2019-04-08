package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@TestAnnotation
public class Test {

    @Check(value="hi")
    private static int a;

    public static void main(String[] args) {

        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);

        if (hasAnnotation) {
            // 获取当前类的注解实例
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            Annotation[] annotations = Test.class.getAnnotations();
            System.out.println("id:"+testAnnotation.id());
            System.out.println("msg:"+testAnnotation.name());
        }
        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            //获取一个成员变量上的注解
            Check check = a.getAnnotation(Check.class);

            if (check != null) {
                System.out.println("check value:" + check.value());
                System.out.println(Test.a);
            }

//            Method testMethod = ThreadPoolTest2.class.getDeclaredMethod("testMethod");
//
//            if ( testMethod != null ) {
//                // 获取方法中的注解
//                Annotation[] ans = testMethod.getAnnotations();
//                for( int i = 0;i < ans.length;i++) {
//                    System.out.println("method testMethod annotation:"+ans[i].annotationType().getSimpleName());
//                }
//            }
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}