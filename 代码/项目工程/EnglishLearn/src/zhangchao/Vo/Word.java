package zhangchao.Vo;

/**
 * 单词实体
 * @author zhangchao
 */
public class Word {
	private String id;
	private String word;
	private String mean;
	private Integer diff;
	private Integer common;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public Integer getDiff() {
		return diff;
	}
	public void setDiff(Integer diff) {
		this.diff = diff;
	}
	public Integer getCommon() {
		return common;
	}
	public void setCommon(Integer common) {
		this.common = common;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}






