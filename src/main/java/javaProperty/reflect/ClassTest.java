package javaProperty.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ClassTest {
    public static void main(String[] args) {
//        printFields();
//        printMethods();
        try {
            printPrivateMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFields() {
        // 1.获取并输出类的名称
        Class mClass = Son.class;
        System.out.println("类的名称：" + mClass.getName());

        // 2.1 获取所有 public 访问权限的变量
        // 包括本类声明的和从父类继承的
        Field[] fields = mClass.getFields();

        // 2.2 获取所有本类声明的变量(所有权限)
        fields = mClass.getDeclaredFields();

        // 3. 遍历变量并输出变量信息
        for (Field field : fields) {
            // 获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getSimpleName()
                    + " " + field.getName());
        }
    }

    private static void printMethods() {
        // 1.获取并输出类的名称
        Class mClass = Son.class;
        System.out.println("类的名称：" + mClass.getName());

        // 2.1 获取所有 public 访问权限的方法（包括父类的）
        Method[] mMethods = mClass.getMethods();

        //2.2 获取所有本类的的方法（不问访问权限）
        //Method[] mMethods = mClass.getDeclaredMethods();

        //3.遍历所有方法
        for (Method method: mMethods) {
            // 获取并输出方法的修饰符
            // 修饰符包括final、native、static等
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers) + " ");

            // 获取并输出方法的返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getSimpleName() + " " + method.getName() + "(");
            //获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            int parameterNum = 0;
            for (Parameter parameter: parameters) {
                if (parameterNum > 0) {
                    System.out.print(", ");
                }
                System.out.print(parameter.getType().getSimpleName() + " " + parameter.getName());
                parameterNum++;
            }
            //获取并输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0){
                System.out.println(")");
            }
            else {
                for (Class c : exceptionTypes) {
                    System.out.println(") throws " + c.getSimpleName());
                }
            }
        }
    }

    private static void printPrivateMethod() throws Exception {
        //1. 获取 Class 类实例
        Son Son = new Son();
        Class mClass = Son.getClass();

        // 2. 获取私有方法
        // 第一个参数为要获取的私有方法的名称
        // 第二个为要获取方法的参数的类型，参数为 Class...，没有参数就不加
        // 可变参数，不需要构建数组
        Method privateMethod = mClass.getDeclaredMethod("printSonMsg", String.class, int.class);

        //3. 开始操作方法
        if (privateMethod != null) {
            //获取私有方法的访问权
            //只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            //使用 invoke 反射调用私有方法
            //privateMethod 是获取到的私有方法
            //Son 要操作的对象
            //后面两个参数传实参
            privateMethod.invoke(Son, "Java Reflect ", 666);
        }
    }
}
