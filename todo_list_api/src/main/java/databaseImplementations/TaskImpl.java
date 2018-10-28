package databaseImplementations;

import interfaces.ITask;

public class TaskImpl implements ITask{	

	private int id;
	private String title;
	private String description;
	private float completion;
	private boolean deleted;

	public TaskImpl(int id, String title, String description) {
		this.description = description;
		this.completion = 0;
		this.title = title;
		this.deleted = false;
		this.id = id;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getCompletion() {
		return Math.round(completion * 100) + "%";
	}

	@Override
	public void setCompletion(float completion) {
		this.completion = completion;
	}
	
	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return deleted ? "X" : String.format("ID: %d, Title: '%s', Description: '%s', Completion: %d%%", 
				id, title, description, Math.round(completion * 100));
	}
}
