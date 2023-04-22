package me.moriya;

import me.moriya.service.GreetingService;
import me.moriya.service.OutputService;
import me.moriya.service.TimeService;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		GreetingService greetingService = new GreetingService("Hello");
		TimeService timeService = new TimeService(true);
		OutputService outputService = new OutputService(greetingService, timeService);
		
		for (int i = 0; i < 5; i++) {
			outputService.generateOutput("Andre");
			Thread.sleep(2000);
		}		
		
	}

}
