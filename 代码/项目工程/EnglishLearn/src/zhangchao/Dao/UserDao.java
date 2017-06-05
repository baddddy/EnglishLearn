package zhangchao.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import zhangchao.Util.JdbcUtil;
import zhangchao.Vo.User;

public class UserDao {
	private Connection conn;
	private CallableStatement stat;
	//根据用户名查用户
	public User getUserByName(String name){
		conn=JdbcUtil.getConnection();
		stat=null;
		ResultSet result=null;
		String sql="{ call ZHANGCHAO.get_user_by_name(?,?,?) }";
		User user=null;
		try {
			stat=conn.prepareCall(sql);
			//填充参数
			stat.setString(1, name);
			stat.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			stat.registerOutParameter(3, oracle.jdbc.OracleTypes.INTEGER);
			stat.execute();
		    result = (ResultSet) stat.getObject(2);
		    //如果有结果
			if(result.next()){
				user=new User();
				user.setName(result.getString("UNAME"));
				user.setEmail(result.getString("EMAIL"));
				user.setPassword(result.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stat, result);
		return user;
	}
	
	//将用户保存到数据库中
	public void addUser(User user){
		conn=JdbcUtil.getConnection();
		stat=null;
		String sql="{ call ZHANGCHAO.add_user(?,?,?,?) }";
		try {
			stat=conn.prepareCall(sql);
			//填充参数
			stat.setString(1, user.getEmail());
			stat.setString(2, user.getName());
			stat.setString(3, user.getPassword());
			stat.registerOutParameter(4, oracle.jdbc.OracleTypes.INTEGER);
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JdbcUtil.close(conn, stat);
	}
}





