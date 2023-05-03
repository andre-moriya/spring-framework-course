package me.moriya.config;

import me.moriya.service.GreetingService;
import me.moriya.service.OutputService;
import me.moriya.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    /*
     * On course, the instructor have used this expression
     * #{new Boolean('${spring.profiles.active}') != 'dev'}
     */
    @Value("#{environment['spring.profiles.active'] != 'dev'}")
    private boolean is24;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
    public TimeService timeService24() {
        return new TimeService(is24);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timeService, name);
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

}
