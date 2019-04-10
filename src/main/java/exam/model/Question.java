package exam.model;

import exam.model.role.Teacher;
import exam.util.DataUtil;
import exam.util.json.JSON;
import exam.util.json.JSONAble;
import exam.util.json.JSONObject;

import java.io.Serializable;

/**
 * @Author 许恒亮
 * @Version 1.0
 */
public class Question implements Serializable, JSONAble {

	private static final long serialVersionUID = 3817117285809180416L;
	private static String[] answerFacades = {"A", "B", "C", "D"};
	private static String[] judgeAnserFacades = {"对", "错"};
	
	private int id;
	private String title;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String answer;
	private String answerFacade;
	private QuestionType type;
	private int point;
	private Teacher teacher;
	
	public String getAnswerFacade() {
		return this.answerFacade;
	}
	
	@Override
	public JSON getJSON() {
		JSONObject json = new JSONObject();
		json.addElement("id", String.valueOf(id)).addElement("title", title).addElement("optionA", optionA)
			.addElement("optionB", optionB).addElement("optionC", optionC).addElement("optionD", optionD)
			.addElement("answer", answer).addElement("point", String.valueOf(point));
		return json;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", optionA="
				+ optionA + ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", answer=" + answer + ", type="
				+ type + ", point=" + point + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	
	protected String generateFacade(String answer) {
		String facade = "";
		if (DataUtil.isValid(answer)) {
			if (this.type == QuestionType.SINGLE) {
				facade = answerFacades[Integer.parseInt(answer)];
			} else if (this.type == QuestionType.MULTI) {
				String[] answers = answer.split(",");
				StringBuilder sb = new StringBuilder();
				for (String a : answers) {
					sb.append(answerFacades[Integer.parseInt(a)]).append(",");
				}
				facade = sb.deleteCharAt(sb.length() - 1).toString();
			} else {
				facade = judgeAnserFacades[Integer.parseInt(answer)];
			}
		}
		return facade;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
		this.answerFacade = generateFacade(answer);
		
	}
	public QuestionType getType() {
		return type;
	}
	public void setType(QuestionType type) {
		this.type = type;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
