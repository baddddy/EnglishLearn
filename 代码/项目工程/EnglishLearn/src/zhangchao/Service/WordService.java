package zhangchao.Service;

import java.util.List;

import zhangchao.Dao.Ct4Dao;
import zhangchao.Vo.Word;

public class WordService {
	private Ct4Dao ct4dao;
	public Ct4Dao getCt4dao() {
		return ct4dao;
	}
	public void setCt4dao(Ct4Dao ct4dao) {
		this.ct4dao = ct4dao;
	}
	//添加单词
	public void addWord(Word m_word){
		if(m_word.getWord().length()>0&&m_word.getWord().length()<6){
			m_word.setDiff(1);
		}else if(m_word.getWord().length()>5&&m_word.getWord().length()<11){
			m_word.setDiff(2);
		}else{
			m_word.setDiff(3);
		}
		ct4dao.addWord(m_word);
	}
	//分页查询单词
	public List<Word>getWordByPage(int pageNum){
		return ct4dao.getWordByPage(pageNum);
	}
	//查询单词
	public List<Word>searchWord(Word m_word){
		return ct4dao.searchWord(m_word);
	}
	//随机查4组单词
	public List<Word>searchWordRandom(){
		return ct4dao.searchWordRandom();
	}
	//翻译单词
	public String tranWord(String word){
		return ct4dao.tranWord(word);
	}
	//删除单词
	public void deleteWord(Word m_word){
		ct4dao.deleteWord(m_word);
	}
	//更新单词
	public void updateWord(Word m_word){
		ct4dao.updateWord(m_word);
	}
	
}



