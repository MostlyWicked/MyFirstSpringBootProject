package models;

public class ListRepresentation {
	private final TaskRepresentation[] tasks;

	public ListRepresentation(TaskRepresentation[] tasks) {
		this.tasks = tasks;
	}
	
	public TaskRepresentation[] getTasks() {
		return tasks;
	}
}
