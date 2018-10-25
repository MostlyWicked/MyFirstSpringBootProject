package utils;

import lists.*;

public class TodoListConverter {
	
	public static String[] todoListToStringArray(ToDoList list) {
		String[] array = new String[list.length()];
		int i = 0;
		for(Task task : list.getTasks()) {
			if(!task.isDeleted()){
				array[i] = task.toString();
				i++;
			}
		}
		
		return array;
	}
}
