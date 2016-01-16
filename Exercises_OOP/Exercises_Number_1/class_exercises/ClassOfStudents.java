package class_exercises;

public class ClassOfStudents {
	
	Teacher teacher;
	Student[] students = new Student[10];
	private String classSubject;
	
	public ClassOfStudents(Teacher teacher, Student[] students) {
		this.teacher = teacher;
		this.students = students;
		setClassSubject(teacher.getSubject());
	}
	
	
	public void setStudentsMarks(double marks){
		for(int i = 0; i < students.length; i++){
			this.students[i].setMark(2);
		}
	}
	
	
	public void setClassSubject(String subject){
		this.classSubject = teacher.getSubject();
		for(int i = 0; i < students.length; i++){
			students[i].setSubject(teacher.getSubject());
		}
	}
	
	
	public void learnInClass(int teaching){
		int teacherTeachings = teacher.Teach(teaching);
		for(int i = 0; i < students.length; i++){
			this.students[i].Study(teacherTeachings);
		}
	}
	
	
	public void examInClass(){
		teacher.Test();
		for(int i = 0; i < students.length; i++){
			if(students[i].getKnowledge() < 30){
				students[i].setMark(2);
			}
			else if(students[i].getKnowledge() >= 30 && students[i].getKnowledge() < 50){
				students[i].setMark(3);
			}
			else if(students[i].getKnowledge() >= 50 && students[i].getKnowledge() < 70){
				students[i].setMark(4);
			}
			else if(students[i].getKnowledge() >= 70 && students[i].getKnowledge() < 90){
				students[i].setMark(5);
			}else{
				students[i].setMark(6);
			}
		}
	}
	
}