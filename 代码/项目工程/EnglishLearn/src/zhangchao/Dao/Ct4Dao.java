package zhangchao.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import zhangchao.Util.JdbcUtil;
import zhangchao.Vo.User;
import zhangchao.Vo.Word;

public class Ct4Dao {
	private Connection conn;
	private CallableStatement stat;
	//查询单词
	public List<Word> searchWord(Word m_word){
		List<Word>words=new ArrayList<Word>();
		conn=JdbcUtil.getConnection();
		stat=null;
		ResultSet result=null;
		String sql="{ call ZHANGCHAO.search_word(?,?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setString(1, m_word.getWord());
			stat.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			stat.execute();
			result = (ResultSet) stat.getObject(2);
			while(result.next()){
				Word word=new Word();
				word.setWord(result.getString("FWORD"));
				word.setMean(result.getString("FMEAN"));
				int diff=Integer.valueOf(result.getString("DIFF"));
				word.setDiff(diff);
				int common=Integer.valueOf(result.getString("COMMON"));
				word.setCommon(common);
				words.add(word);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat, result);
		return words;
	}
	//添加单词
	public void addWord(Word m_word){
		conn=JdbcUtil.getConnection();
		stat=null;
		String sql="{ call ZHANGCHAO.add_word(?,?,?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setString(1, m_word.getWord());
			stat.setString(2, m_word.getMean());
			stat.setInt(3, m_word.getDiff());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat);
	}
	//共有多少数据
	public int getSum(){
		int Sum=0;
		conn=JdbcUtil.getConnection();
		stat=null;
		String sql="{ call ZHANGCHAO.get_word_total(?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.registerOutParameter(1, oracle.jdbc.OracleTypes.INTEGER);
			stat.execute();
			Integer result=(Integer)stat.getObject(1);
			Sum=result;
			//double sum=result/10.0;
			//pageSum=(int)Math.ceil(sum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat);
		return Sum;
	}
	
	//分页查询单词
	public List<Word> getWordByPage(int pageNum){
		int Sum=this.getSum();
		//算出共有多少页
		double sum=Sum/10.0;
		int pageSum=(int)Math.ceil(sum);
		//如果要查的页数比总页数还多，返回空
		int start=1+10*(pageNum-1);
		int end=0;
		if(pageNum>pageSum){
			return null;
		}else if(pageNum==pageSum){
			end=Sum;
		}else{
			end=10*pageNum;
		}
		List<Word>words=new ArrayList<Word>();
		conn=JdbcUtil.getConnection();
		ResultSet result=null;
		stat=null;
		String sql="{ call ZHANGCHAO.get_word_page(?,?,?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setInt(1, start);
			stat.setInt(2, end);
			stat.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			stat.execute();
			result = (ResultSet) stat.getObject(3);
		    //如果有结果
			while(result.next()){
				Word word=new Word();
				word.setWord(result.getString("FWORD"));
				word.setMean(result.getString("FMEAN"));
				int diff=Integer.valueOf(result.getString("DIFF"));
				word.setDiff(diff);
				int common=Integer.valueOf(result.getString("COMMON"));
				word.setCommon(common);
				words.add(word);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat,result);
		return words;
	}
	//删除单词
	public void deleteWord(Word m_word){
		conn=JdbcUtil.getConnection();
		stat=null;
		String sql="{ call ZHANGCHAO.delete_word(?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setString(1, m_word.getWord());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat);
	}
	//更新单词
	public void updateWord(Word m_word){
		conn=JdbcUtil.getConnection();
		stat=null;
		String sql="{ call ZHANGCHAO.update_Ct4(?,?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setString(1, m_word.getWord());
			stat.setString(2,m_word.getMean());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat);
	}

	//随机取出4个单词
	public List<Word> searchWordRandom(){
		List<Word>words=new ArrayList<Word>();
		conn=JdbcUtil.getConnection();
		stat=null;
		ResultSet result=null;
		String sql="{ call ZHANGCHAO.get_word_random(?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			stat.execute();
			result = (ResultSet) stat.getObject(1);
			while(result.next()){
				Word word=new Word();
				word.setWord(result.getString("TWORD"));
				word.setMean(result.getString("TMEAN"));
				words.add(word);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat, result);
		return words;
	}
	//**************************翻译单词
	public String tranWord(String word){
		conn=JdbcUtil.getConnection();
		stat=null;
		String mean=null;
		String sql="{ call ZHANGCHAO.tran_word(?,?) }";
		try {
			stat=conn.prepareCall(sql);
			stat.setString(1, word);
			stat.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);
			stat.execute();
			mean=(String)stat.getObject(2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//关闭连接
		JdbcUtil.close(conn, stat);
		return mean;
	}
	
}




