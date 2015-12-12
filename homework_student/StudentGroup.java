package homework_student;

public class StudentGroup {
	
	String groupSubject;
	Student[] students;
	int freePlaces;
	
	//default constructor
	StudentGroup(){
		
		students = new Student[5];
		freePlaces = 5;
		
	}
	
	//constructor s parametur
	StudentGroup(String subject){
		
		this();
		this.groupSubject = subject;
		
	}
	
	//metod za dobavqne na studenti v grupata
	void addStudent(Student a){
		
		int i = students.length - freePlaces;
		
		if(a.subject.equalsIgnoreCase(groupSubject)){
			
			if(freePlaces > 0 && students[i] == null){
				
				students[i] = a;
				freePlaces -= 1;
				
			}
		}
	}
	
	//izprazvane na grupata
	void emptyGroup(){
		
		for(int i = 0; i < students.length; i++){
			
			students[i] = null;
			freePlaces += 1;
			
		}
		
		
		
	}
	
	//printirane na studentite v grupata
	void printStudentsInGroup(){
		
		System.out.println("Group: " + this.groupSubject);
		
		for(int i = 0; i < students.length; i++){
			
			System.out.println(students[i].name + ", " + students[i].subject + ", " + students[i].grade + ", "  + 
					students[i].yearInCollege + ", " + students[i].age + ", " + students[i].isDegree + ", " +students[i].money);
			
		}
		
	}
	
	//printirane na nai-dobria student
	void bestStudent(){
		
		double maxDegree = students[0].grade;
		int index = 0;
		
		for(int i = 1; i < students.length; i++){
			
			if(maxDegree < students[i].grade){
				
				maxDegree = students[i].grade;
				index = i;
				
			}
			
		}
		
		System.out.println("The best student in the group is " + students[index].name + " with grade " + students[index].grade + ". \n");
		
	}
}
