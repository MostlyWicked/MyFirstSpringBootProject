package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lists.Task;
import lists.ToDoList;
import representations.AddTaskBody;
import representations.ListRepresentation;
import representations.TaskRepresentation;

@RestController
public class ListController {
	
	public static ToDoList todoList = new ToDoList();
	
	@RequestMapping(value = "/add_task", method = RequestMethod.POST)
	public ListRepresentation addTask(@RequestBody AddTaskBody addTaskBody){
		todoList.addTask(addTaskBody.getTitle(), addTaskBody.getDescription());
		return new ListRepresentation(utils.TodoListConverter.todoListToTaskRepresentationArray(todoList));
	}
	
	@RequestMapping(value = "/get_all_tasks", method = RequestMethod.GET)
	public ListRepresentation getTasks(){
		return new ListRepresentation(utils.TodoListConverter.todoListToTaskRepresentationArray(todoList));
	}
	
	@RequestMapping(value = "/get_task_by_title", method = RequestMethod.GET)
	public TaskRepresentation getTaskByTitle(@RequestParam String title) {
		Task task = todoList.getTaskByTitle(title);
		return new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
	}
	
	@RequestMapping(value = "/get_task_by_id", method = RequestMethod.GET)
	public TaskRepresentation getTaskById(@RequestParam int id) {
		Task task = todoList.getTaskById(id);
		return new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
	}
	
	@RequestMapping(value = "/delete_task_by_id", method = RequestMethod.GET)
	public ListRepresentation deleteTaskById(@RequestParam int id) {
		todoList.deleteTask(id);
		return new ListRepresentation(utils.TodoListConverter.todoListToTaskRepresentationArray(todoList));
	}
	
	

}
