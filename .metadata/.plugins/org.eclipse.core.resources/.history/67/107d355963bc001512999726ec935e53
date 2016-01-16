package homework_abstraction;

public class AllWork {
	
	private static final int MAX_PLACES_FOR_TASKS = 10;
	private Task[] tasks = new Task[10];
	private int freePlacesForTasks;
	private static int currentUnassignedTask = 0;
	
	public AllWork(){
		tasks = new Task[MAX_PLACES_FOR_TASKS];
		freePlacesForTasks = MAX_PLACES_FOR_TASKS;
	}
	
	public void addTask(Task task){
		int i = MAX_PLACES_FOR_TASKS - freePlacesForTasks;
		if(freePlacesForTasks > 0 && tasks[i] == null){
			tasks[i] = task;
			freePlacesForTasks -= 1;
		}else{
			System.out.println("There is no free places for tasks.");
		}
	}

	public Task getNextTask(){
		if(currentUnassignedTask <= MAX_PLACES_FOR_TASKS - 1 && tasks[currentUnassignedTask].freeTask == true){
			return tasks[currentUnassignedTask];
		}
		else if(currentUnassignedTask < MAX_PLACES_FOR_TASKS - 1 && tasks[currentUnassignedTask].freeTask == false){
			currentUnassignedTask++;
			return tasks[currentUnassignedTask];
		}
		else{
			tasks[currentUnassignedTask] = null;
			return tasks[currentUnassignedTask];
		}
		
	}
	
	public boolean isAllWorkDone(){
		int count = 0;
		for(int i = 0; i < MAX_PLACES_FOR_TASKS; i++){
			if(tasks[i].getWorkingHoursToFinishTheTask() == 0){
				count++;
			}else{
				count--;
			}
		}
		if(count == MAX_PLACES_FOR_TASKS){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
