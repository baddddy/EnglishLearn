package zhangchao.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

//从文件中读入数据导入的数据库中
public class LeadData {
	//private Connection conn;
	//private PreparedStatement stat;
	@Test
	public void lead() throws FileNotFoundException, SQLException{
		//读数据
		FileInputStream file=new FileInputStream("D:/9.txt");
		Scanner sc=new Scanner(file);
		int index=1;
		while(sc.hasNext()){
			String a=sc.nextLine();
			String b=sc.nextLine();
			Connection conn=JdbcUtil.getConnection();
			String sql="INSERT INTO T_TRAN VALUES(?,?,?)";
			PreparedStatement stat=conn.prepareStatement(sql);
			stat.setInt(1, index);
			stat.setString(2, a);
			stat.setString(3, b);
			stat.executeQuery();
			JdbcUtil.close2(conn, stat);
			index++;
		}
		sc.close();
	}
	
}






