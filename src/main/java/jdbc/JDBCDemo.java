package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1、引入JDBC的jar包
 * 2、引入驱动器 Class.forName(DBDRIVER); "com.mysql.jdbc.Driver"
 * 3、创建连接
 * 4、发送SQL语句，接受数据库对数据库执行SQL语句
 * 5、解析执行结果
 */

public class JDBCDemo {
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://localhost:3306/my_database";
    public static final String DBUSER = "root";
    public static final String DBPASS = "951021";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void save(){
        Connection con = getConnection();
        String sql = "insert into Info values(?, ?, ?)";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "123");
            psmt.setString(2, "12");
            psmt.setInt(3, 3);
            int count = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(psmt != null){
                try {
                    psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void delete(){
        Connection con = getConnection();
        String sql = "delete from Info where id=?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "10330070");
            int count = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(psmt != null){
                try {
                    psmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block  
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(){
        Connection con = getConnection();
        String sql = "update Info set age = ? where id = ?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, 22);
            psmt.setString(2, "111313");
            int count = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(psmt != null){
                try {
                    psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<Info> query(){
        List<Info> list = new ArrayList<Info>();
        Connection con = getConnection();
        String sql = "select * from Info";
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();

            while(rs.next()){    //依次取出数据  
                Info info = new Info();
                info.setId(rs.getString("id"));
                info.setPass(rs.getString("pass"));
                info.setAge(rs.getInt("age"));
                System.out.println(info.getId() +"\t" + info.getPass() + "\t" + info.getAge());
                list.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(psmt != null){
                try {
                    psmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(query().get(0).getAge());

    }
}  