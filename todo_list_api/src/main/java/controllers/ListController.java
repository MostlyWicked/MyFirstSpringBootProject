package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lists.ToDoList;
import representations.AddTaskBody;
import representations.ListRepresentation;

@RestController
public class ListController {
	
	public static ToDoList todoList = new ToDoList();
	
	@RequestMapping(value = "/add_task", method = RequestMethod.POST)
	public ListRepresentation addTask(@RequestBody AddTaskBody addTaskBody){
		todoList.addTask(addTaskBody.getTitle(), addTaskBody.getDescription());
		return new ListRepresentation(utils.TodoListConverter.todoListToStringArray(todoList));
	}
	
	@RequestMapping(value = "/get_all_tasks", method = RequestMethod.GET)
	public ListRepresentation getTasks(){
		return new ListRepresentation(utils.TodoListConverter.todoListToStringArray(todoList));
	}
	
	/*
	@RequestMapping(value = "/get_task_by_title", method = RequestMethod.GET)
	public String getTaskByTitle(@RequestParam String title) {
		return null;//todoList.getTaskByTitle(title);
	}
	
	@RequestMapping(value = "/get_task_by_id", method = RequestMethod.GET)
	public String getTaskById(@RequestParam String title) {
		return null;
	}
	
	@RequestMapping(value = "/delete_task_by_id", method = RequestMethod.GET)
	public String deleteTaskById(@RequestParam String title) {
		return null;
	}
	*/
	

}
