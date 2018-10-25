package utils;

import lists.*;
import representations.TaskRepresentation;

public class TodoListConverter {
	
	public static TaskRepresentation[] todoListToTaskRepresentationArray(ToDoList list) {
		TaskRepresentation[] array = new TaskRepresentation[list.length()];
		int i = 0;
		for(Task task : list.getTasks()) {
			if(!task.isDeleted()){
				array[i] = new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
				i++;
			}
		}
		
		return array;
	}
}
