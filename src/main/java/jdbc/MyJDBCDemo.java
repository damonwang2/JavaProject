package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、引入JDBC的jar包
 * 2、引入驱动器 Class.forName(DBDRIVER); "com.mysql.jdbc.Driver"
 * 3、创建连接
 * 4、发送SQL语句，接受数据库对数据库执行SQL语句
 * 5、解析执行结果
 */

public class MyJDBCDemo {

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/my_database";
    public static String user = "root";
    public static String password = "951021";

    //获取连接：这里采用硬编码，不是从外部获取url，username，password
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //要求JVM查找并加载指定的类，也就是说JVM会执行该类的静态代码段。
            Class.forName(DBDRIVER);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<Student> query(){
        List<Student> list = new ArrayList<Student>();
        //static方法可以直接调用，连接到数据库
        Connection connection = getConnection();
        String sql = "select * from student";
        //这里
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //发送SQL语句到该连接（会话）中，返回
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            //解析执行结果
            while(resultSet.next()){    //依次取出数据
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                System.out.println(student.getId() + "\t" + student.getName());
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        query();
    }


}
