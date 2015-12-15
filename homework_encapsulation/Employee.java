package homework_encapsulation;

public class Employee {
	
	private String name;
	private Task currentTask;
	private int hoursLeftForToday;
	
	//setter i getter za imeto na rabotnika
	public void setNameEmployee(String name){
		
		if(name != null && !name.equals("")){
			
			this.name = name;
			
		}
		
	}
	
	public String getNameEmployee(){
		
		if(name == null){
			
			return "No name";
			
		}
		
		return name;
		
	}
	
	//setter s proverka za ostanalite chasove rabota
	public void setHoursLeftForToday(int hoursLeft){
		
		if(hoursLeft >= 0){
			
			this.hoursLeftForToday = hoursLeft;
			
		}
		
	}
	
	public int getHoursLeftForToday(){
		
		return hoursLeftForToday;
		
	}
	
	//konsturktor za rabotnika samo s ime
	Employee(String name){
		
		setNameEmployee(name);
		
	}
	
	Employee(Task currentTask){
		
		this.setCurrentTask(currentTask);
		
	}
	
	//metod work koito promenq chasovete na rabotnika do kraq na denq
	//i kolko rabota mu ostava po zadachata
	void work(){
		
		if(this.hoursLeftForToday < this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			
			this.getCurrentTask().setWorkingHoursToFinishTheTask(this.getCurrentTask().getWorkingHoursToFinishTheTask() - this.hoursLeftForToday);
			this.setHoursLeftForToday(0);
			
		}
		if(this.hoursLeftForToday > this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			
			this.setHoursLeftForToday(this.hoursLeftForToday - this.getCurrentTask().getWorkingHoursToFinishTheTask());
			this.getCurrentTask().setWorkingHoursToFinishTheTask(0);
			
		}
		if(this.hoursLeftForToday == this.getCurrentTask().getWorkingHoursToFinishTheTask()){
			
			this.getCurrentTask().setWorkingHoursToFinishTheTask(0);
			this.setHoursLeftForToday(0);
			
		}
		
	}
	
	//moje da ne e taka no vse pak izkarva momentnite stoinosti
	void showReport(){
		
		System.out.println("Report for today:");
		System.out.println("Name of the employee: " + this.getNameEmployee());
		System.out.println("Task of the employee: " + this.getCurrentTask().getName());
		System.out.println("Hours left until the workday end: " + this.getHoursLeftForToday());
		System.out.println("Hours left until the task is finished: " + this.getCurrentTask().getWorkingHoursToFinishTheTask());
		System.out.println();
	}
	
	//getter i setter za taska po koito raboti employee-to
	public Task getCurrentTask() {
		
		return currentTask;
		
	}
	
	public void setCurrentTask(Task currentTask) {
		
		this.currentTask = currentTask;
		
	}
	
}
