package models;

public class GreetingTest {
	private final long id;
	private final String content;
	
	public GreetingTest(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

}
