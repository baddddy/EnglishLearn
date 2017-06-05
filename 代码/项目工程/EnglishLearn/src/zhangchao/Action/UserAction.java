package zhangchao.Action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhangchao.Dao.UserDao;
import zhangchao.Service.UserService;
import zhangchao.Vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户action层
 * @author zhangchao
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动接收用户实体
	private User user = new User();
	public User getModel() {
		return user;
	}
	//***************************************
	//注入userService
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//***************************************
	//用户登录页面
	public String loginPage(){
		return "loginPage";
	}
	//用户登录
	public String login(){
		//1.判断用户是否存在？否，返回登录界面
		if(userService.isExistUser(user.getName())==false){
			this.addActionError("用户不存在，请先注册！");
			return "loginPage";
		}
		//2.判断密码是否有误？否
		if(userService.isPassCorrect(user)==false){
			this.addActionError("密码错误！");
			return "loginPage";
		}
		return "menu";
	}
	//用户注册页面
	public String registPage(){
		return "registPage";
	}
	//用户注册
	public String regist(){
		if(user==null){
			this.addActionError("未正确提交注册表单！");
			return "registPage";
		}
		//1.查询用户是否存在？是，返回错误
		if(userService.isExistUser(user.getName())==true){
			this.addActionError("用户名已存在！请重填用户名后提交");
			return "registPage";
		}
		//2.将用户插入数据库
		userService.addUser(user);
		this.addActionMessage("注册成功！");
		return "msg";
	}
	//回主菜单
	public String userMenu(){
		return "menu";
	}
}




