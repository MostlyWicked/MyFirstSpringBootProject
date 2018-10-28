package interfaces;

public interface ITask {
	//TODO - add javadocs
	String getDescription();

	void setDescription(String description);

	String getCompletion();

	void setCompletion(float completion);
	
	String getTitle();

	void setTitle(String title);
	
	boolean isDeleted();

	void setDeleted(boolean deleted);
	
	int getId();
}
