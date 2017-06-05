package zhangchao.Util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;

/**
 * 连接数据库的工具类
 * c3p0数据库连接池
 * @author zhangchao
 */

public class JdbcUtil {
    //c3p0连接对象
    static ComboPooledDataSource combopool=null;
    static{
    	//加载默认的c3p0配置文件
    	combopool = new ComboPooledDataSource();
    }
    /**
     * 获得数据库连接
     */
    public static Connection getConnection(){
        try {
            return combopool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 数据库关闭操作
     */
    public static void close(Connection conn, CallableStatement stat, ResultSet result){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
            	stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result!=null){
            try {
            	result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //重载无结果集的关闭
    public static void close(Connection conn, CallableStatement stat){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
            	stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //*****************************************
    public static void close2(Connection conn, PreparedStatement stat){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
            	stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}






