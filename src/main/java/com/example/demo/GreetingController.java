package com.example.demo;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting/v1")
    public Greeting greetingV1(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, ""));
    }
    
    @RequestMapping("/greeting/v2")
    public Greeting greetingV2(@RequestParam(value="name", defaultValue="World") String name) {
      
    	Calendar c = Calendar.getInstance();
    	int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
    	String greeting = "";
    	if(timeOfDay >= 0 && timeOfDay < 12){
    	    greeting = "Good Morning";        
    	}else if(timeOfDay >= 12 && timeOfDay < 16){
    	    greeting = "Good Afternoon"; 
    	}else if(timeOfDay >= 16 && timeOfDay < 21){
    	    greeting = "Good Evening"; 
    	}else if(timeOfDay >= 21 && timeOfDay < 24){
    	    greeting = "Good Night"; 
    	}
    	return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, greeting));
    }
    
}