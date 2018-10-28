package interfaces;

import java.util.List;

import databaseImplementations.TaskFactory;
import enums.DBType;

public interface IToDoList {
	public List<ITask> getTasks();
	
	 void addTask(String title, String description);
	
	 int numOfTasks();
	
	/**
	 * Soft delete by id (task is set as deleted, preserved in data structure).
	 * 
	 * @param id
	 * @return true if task was deleted, false if task was not deleted
	 */
	 boolean deleteTask(int id);
	
	 ITask getTaskById(int id);
	
	 ITask getTaskByTitle(String title);
}
