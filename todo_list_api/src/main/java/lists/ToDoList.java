package lists;

import java.util.ArrayList;
import java.util.List;

// This class *roughly* simulates a database

public class ToDoList {
	private List<Task> tasks;
	private int sizeWithoutDeleted;

	public ToDoList() {
		this.tasks = new ArrayList<>();
		this.sizeWithoutDeleted = 0;
	}
	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		sizeWithoutDeleted++;
		tasks.add(task);
	}
	
	public void addTask(String title, String description) {
		addTask(new Task(tasks.size() + 1, title, description));
	}
	
	public int length() {
		return sizeWithoutDeleted;
	}
	
	/**
	 * Soft delete by id (task is set as deleted, preserved in data structure).
	 * 
	 * @param id
	 */
	public void deleteTask(int id) {
		sizeWithoutDeleted--;
		Task task = getTaskById(id);
		if(task != null) task.setDeleted(true);;
	}
	
	public Task getTaskById(int id) {
		return tasks.stream().filter(task -> id == task.getId()).findFirst().orElse(null);
	}
	
	public Task getTaskByTitle(String title){
		return tasks.stream().filter(task -> title.equals(task.getTitle())).findFirst().orElse(null);
	}
	
}
