package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import databaseImplementations.DBFactory;
import enums.DBType;
import exceptions.TaskNotFoundException;
import interfaces.IToDoList;
import interfaces.ITask;
import models.AddTaskBody;
import models.ListRepresentation;
import models.TaskRepresentation;

@RestController
public class ListController {
	
	private IToDoList todoList = DBFactory.getListInstance(DBType.SimulationByJavaObjects); //With JSystem or a similar test framework the type can come from the SUT 
	
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
		ITask task = todoList.getTaskByTitle(title);
		return new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
	}
	
	//TODO - currently returns deleted tasks too
	@RequestMapping(value = "/get_task_by_id", method = RequestMethod.GET)
	public TaskRepresentation getTaskById(@RequestParam int id) throws TaskNotFoundException{
		String errorMsg = "The task with ID " + id + " was not found in tasks list.";
		ITask task = todoList.getTaskById(id);
		if (task == null || task.isDeleted()) {
			throw new TaskNotFoundException(errorMsg);
		}
		return new TaskRepresentation(task.getId(), task.getTitle(), task.getDescription(), task.getCompletion());
	}
	
	@RequestMapping(value = "/delete_task_by_id", method = RequestMethod.GET)
	public ListRepresentation deleteTaskById(@RequestParam int id) throws TaskNotFoundException {
		if(!todoList.deleteTask(id))
			throw new TaskNotFoundException("Could not delete task with ID " + id +" (task not found)");
		return new ListRepresentation(utils.TodoListConverter.todoListToTaskRepresentationArray(todoList));
	}
	
	

}
