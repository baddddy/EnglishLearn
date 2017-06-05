package zhangchao.Action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import zhangchao.Service.WordService;
import zhangchao.Vo.User;
import zhangchao.Vo.Word;

public class WordAction extends ActionSupport implements ModelDriven<Word>{
	//模型驱动接收用户实体
	private Word m_word = new Word();
	public Word getModel() {
		return m_word;
	}
	//Spring 注入
	private WordService wordService;
	public WordService getWordService() {
		return wordService;
	}
	public void setWordService(WordService wordService) {
		this.wordService = wordService;
	}
	//单词模块页面
	public String wordPage(){
		return "wordPage";
	}
	//例句模块页面
	public String phrasePage(){
		return "phrasePage";
	}
	//试题模块页面
	public String examPage(){
		//查询4组单词保存在session中
		List<Word>exam=wordService.searchWordRandom();
		for(int i=0;i<exam.size();i++){
			exam.get(i).setId("e"+i);
		}
		ActionContext.getContext().getSession().put("exam", exam);
		//把答案打印下来
		FileOutputStream fileout=null;
		for(int i=0;i<exam.size();i++){
			System.out.print(exam.get(i).getMean()+"：");
			System.out.println(exam.get(i).getWord());
		}
		return "examPage";
	}
	//查询模块页面
	private int pageNum;
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public String searchPage(){
		//使用分页查询的方式展示出单词
		List<Word>words=wordService.getWordByPage(pageNum);
		//保存在值栈中
		ActionContext.getContext().getValueStack().set("words", words);
		return "page";
	}
	public String searchByPage(){
		//使用分页查询的方式展示出单词
		List<Word>words=wordService.getWordByPage(pageNum);
		if(words!=null){
			//保存在值栈中
			ActionContext.getContext().getValueStack().set("words", words);
		}else{
			this.addActionError("页数不合理，此页没有数据！");
		}
		return "page";
	}
	//添加单词
	public String addWord(){
		wordService.addWord(m_word);
		this.addActionMessage("添加成功");
		return "wordPage";
	}
	//删除
	public String deleteWord(){
		wordService.deleteWord(m_word);
		this.addActionMessage("删除单词"+m_word.getWord()+"成功");
		return "msg2";
	}
	//更新
	public String updateWord(){
		wordService.updateWord(m_word);
		this.addActionMessage("更新单词"+m_word.getWord()+"成功");
		return "updateWord";
	}
	public String updateWordPage(){
		return "updateWord";
	}
	//模糊查询单词
	public String searchWord(){
		List<Word>search=wordService.searchWord(m_word);
		ActionContext.getContext().getValueStack().set("search", search);
		return "searchPage";
	}
	public String searchWordPage(){
		return "searchPage";
	}
	//****************************试题和翻译部分
	//检查结果
	private String e0;
	private String e1;
	private String e2;
	private String e3;
	public void setE0(String e0) {
		this.e0 = e0;
	}
	public void setE1(String e1) {
		this.e1 = e1;
	}
	public void setE2(String e2) {
		this.e2 = e2;
	}
	public void setE3(String e3) {
		this.e3 = e3;
	}
	public String checkWord(){
		List<Word>exam=(List<Word>) ActionContext.getContext().getSession().get("exam");
		if(exam.get(0).getWord().equals(e0)==false){
			this.addActionMessage("第1个单词不正确");
			return "examPage";
		}else if(exam.get(1).getWord().equals(e1)==false){
			this.addActionMessage("第2个单词不正确");
			return "examPage";
		}else if(exam.get(2).getWord().equals(e2)==false){
			this.addActionMessage("第3个单词不正确");
			return "examPage";
		}else if(exam.get(3).getWord().equals(e3)==false){
			this.addActionMessage("第4个单词不正确");
			return "examPage";
		}
		this.addActionMessage("恭喜全部正确！");
		return "msg2";
	}
	public String tranWordPage(){
		return "tranWord";
	}
	private String areaTran;
	//接收翻译的内容
	public void setAreaTran(String areaTran) {
		this.areaTran = areaTran;
	}
	public String getAreaTran() {
		return areaTran;
	}
	public String tranWord(){
		String[] words=areaTran.split(" ");
		String result="";
		for(int i=0;i<words.length;i++){
			result+=wordService.tranWord(words[i]);
		}
		areaTran=result;
		return "tranWord";
	}
	
}




