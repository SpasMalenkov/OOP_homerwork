package class_exercises;

public class Student extends Human{
	
	static private int MAX_KNOWLEDGE = 100;
	private double mark;
	private String subject;
	private int knowledge;
	
	public Student(String name, String surname) {
		super(name, surname);
	}
	
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	public void Study(int studyKnowledge){
		if(studyKnowledge < 0){
			this.knowledge = knowledge;
		}else{
			this.knowledge += studyKnowledge;
		}
	}
	
	
	public void StudyHome(int studyKnowledge){
		if(studyKnowledge < 0){
			this.Study(0);
		}else if(studyKnowledge > (MAX_KNOWLEDGE - this.getKnowledge())){
			this.Study(MAX_KNOWLEDGE - this.getKnowledge());
		}else{
			this.Study(studyKnowledge);
		}
	}
	
	public int getKnowledge(){
		return knowledge;
	}
}
