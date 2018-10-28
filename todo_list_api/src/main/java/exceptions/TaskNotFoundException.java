package exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends Exception{
 public TaskNotFoundException() {}
 
 public TaskNotFoundException(String message) {
	 super(message);
 }
 
 public TaskNotFoundException(Throwable cause) {
	 super(cause);
 }
 
 public TaskNotFoundException(String message, Throwable cause) {
	 super(message, cause);
 }
 

}
