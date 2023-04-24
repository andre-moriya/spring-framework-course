package me.moriya;

import me.moriya.config.ApplicationConfig;
import me.moriya.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		OutputService outputService = context.getBean(OutputService.class);
		
		for (int i = 0; i < 5; i++) {
			outputService.generateOutput("Andre");
			Thread.sleep(2000);
		}		
		
	}

}
