package zhangchao.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhangchao.Dao.UserDao;
import zhangchao.Vo.User;

/**
 * 用户逻辑层
 * @author zhangchao
 */
public class UserService {
	//Spring 配置文件注入dao层
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//判断用户是否存在
	public boolean isExistUser(String name){
		if(userDao.getUserByName(name)!=null){
			return true;
		}else{
			return false;
		}
	}
	//将用户插入数据库
	public void addUser(User user){
		userDao.addUser(user);
	}
	//判断用户密码是否正确
	public boolean isPassCorrect(User user){
		User user2=userDao.getUserByName(user.getName());
		if(user2.getPassword().equals(user.getPassword())){
			return true;
		}else{
			return false;
		}
	}
}






