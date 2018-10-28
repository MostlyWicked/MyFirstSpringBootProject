package databaseImplementations;

import java.util.ArrayList;
import java.util.List;
import enums.DBType;
import interfaces.IToDoList;
import interfaces.ITask;

// This class roughly simulates a database

class ToDoList implements IToDoList{
	private List<ITask> tasks;
	private int sizeWithoutDeleted;

	ToDoList() {
		this.tasks = new ArrayList<>();
		this.sizeWithoutDeleted = 0;
	}
	public List<ITask> getTasks() {
		return tasks;
	}

	private void addTask(ITask task) {
		sizeWithoutDeleted++;
		tasks.add(task);
	}
	
	@Override
	public void addTask(String title, String description) {
		addTask(TaskFactory.getTaskObject(DBType.SimulationByJavaObjects,tasks.size() + 1, title, description));
	}
	
	@Override
	public int numOfTasks() {
		return sizeWithoutDeleted;
	}
	
	@Override
	public boolean deleteTask(int id) {
		ITask task = getTaskById(id);
		if(task == null || task.isDeleted())
			return false;
		sizeWithoutDeleted--;
		task.setDeleted(true);;
		return true;
	}
	
	@Override
	public ITask getTaskById(int id) {
		return tasks.stream().filter(task -> id == task.getId()).findFirst().orElse(null);
	}
	
	@Override
	public ITask getTaskByTitle(String title){
		return tasks.stream().filter(task -> title.equals(task.getTitle())).findFirst().orElse(null);
	}
	
}
