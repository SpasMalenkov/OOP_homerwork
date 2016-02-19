package task_homework_finished;

public class Task implements ITask{
	
	private static int count = 1;
	private String name;
	private int number;
	
	public Task(String name, int number){
		this.setName(name);
		this.setNumber(number);
		count++;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		if(number <= 0 || number > 4){
			this.number = 1;
		}else{
			this.number = number;
		}
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		if(name != null && !name.equals("")){
			this.name = name;
		}
		else{
			this.name = "Task" + count;
		}
	}

	@Override
	public void doSomeWork() {
		System.out.println(this.getName());
		switch(this.getNumber()){
		case 1:
			System.out.println("Shte karam dnes kolata.");
			int kilometers = (int)(Math.random() * 120 + 1);
			System.out.println("Karah kolata " + kilometers + " kilmetra");
			break;
		case 2:
			System.out.println("Sreshtam se s priqteli i pusha nargile. :D");
			break;
		case 3:
			System.out.println("Shte razvejdam kucheto.");
			int minutes = (int)(Math.random() * 60 + 1);
			System.out.println("Razhojdah kucheto " + minutes + " minuti.");
			break;
		case 4:
			System.out.println("Shte piq tazi vecher s priqteli.");
			int liters = (int)(Math.random() * 3 + 1);
			System.out.println("Izpihme " + liters + " litur/litra alkohol...");
			break;
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
