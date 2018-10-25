package lists;

public class Task {	

	private int id;
	private String title;
	private String description;
	private float completion;
	private boolean deleted;

	public Task(int id, String title, String description) {
		this.description = description;
		this.completion = 0;
		this.title = title;
		this.deleted = false;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCompletion() {
		return completion;
	}

	public void setCompletion(float completion) {
		this.completion = completion;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return deleted ? "X" : String.format("ID: %d, Title: '%s', Description: '%s', Completion: %d%%", 
				id, title, description, Math.round(completion * 100));
	}
}
