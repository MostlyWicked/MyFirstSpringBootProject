package com.todo.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lists.ToDoList;

@SpringBootApplication 
@ComponentScan({"controllers"}) 
public class TodoListApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TodoListApiApplication.class, args);
	}
}
