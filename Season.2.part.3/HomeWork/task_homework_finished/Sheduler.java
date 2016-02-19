package task_homework_finished;

import java.util.LinkedList;
import java.util.Queue;

public class Sheduler {
	
	private static Sheduler current;
	private Queue<ITask> queue;
	
	private Sheduler(){
		current = this;
		queue = new LinkedList<>();
	}
	
	public void pushTask(Task task){
		if(task != null){
			this.queue.add(task);
		}
	}
	
	public static void createSheduler(){
		if(current == null){
			new Sheduler();
		}
	}
	
	public static Sheduler getSheduler(){
		if(current == null){
			new Sheduler();
		}
		return current;
	}
	
	public static void main(String[] args) {
		
		Sheduler sheduler = getSheduler();
		ITask[] tasks = new ITask[12];
		//index vmesto prosto i
		for(int index = 0; index < tasks.length; index++){
			int number = (int)(Math.random() *4) + 1;
			tasks[index] = new Task("Task number " + index, number);
			sheduler.queue.add(tasks[index]);
			System.out.println("Input: " + tasks[index].toString());
		}
		System.out.println();
		while(!sheduler.queue.isEmpty()){
			sheduler.queue.poll().doSomeWork();
		}
	}
}
