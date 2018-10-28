package controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

import models.GreetingTest;

@RestController
public class GreetingTestController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public GreetingTest greeting (@RequestParam(value="name", defaultValue="World")String name) {
		return new GreetingTest(counter.incrementAndGet(), String.format(template, name));
	}
}
