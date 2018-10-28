package utils;

import interfaces.ITask;
import interfaces.IToDoList;
import models.TaskRepresentation;

public class TodoListConverter {
	
	public static TaskRepresentation[] todoListToTaskRepresentationArray(IToDoList list) {
		TaskRepresentation[] array = new TaskRepresentation[list.numOfTasks()];
		int i = 0;
		for(ITask task : list.getTasks()) {
			if(!task.isDeleted()){
				array[i] = new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
				i++;
			}
		}
		
		return array;
	}
}
