package blog;

import java.util.*;

public class MyCompatorDemo {
    public static void main(String[] args) {

        List<MyClass> list1 = new ArrayList<MyClass>();
        list1.add(new MyClass("a", 1));
        list1.add(new MyClass("b", 2));
        list1.add(new MyClass("c", 3));
        list1.add(new MyClass("d", 4));
        list1.add(new MyClass("e", 5));

        //按照MyClass内部的compareTo方法进行排序
        Collections.sort(list1);

        //输出
        for(MyClass myClass : list1){
            System.out.println(myClass.name + " " + myClass.id);
        }

        //初始化序列
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 3);

        //使用默认排序方式（升序）
        Collections.sort(list2);
        System.out.println(list2);

        //使用自定义排序方式（降序）
        MyComparator c = new MyComparator();
        list2.sort(c);
        System.out.println(list2);

        //匿名内部类的对象
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        };

        //匿名对象
        list2.sort(new MyComparator());
        System.out.println(list2);

        //匿名内部类的匿名对象
        list2.sort(null);

        System.out.println(list2);

        System.out.println(null == null);
    }
}

class MyClass implements Comparable{
    String name = "";
    int id = 0;

    MyClass(){}
    MyClass(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        MyClass myClass = (MyClass) o;
        return -this.name.compareTo(myClass.name);
    }
}


//实现Comparator的类
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b){
        return b - a;
    }
}

