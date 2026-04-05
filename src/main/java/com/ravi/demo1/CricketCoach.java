package com.ravi.demo1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupTasks(){
        System.out.println("In PostConstruct: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupTasks(){
        System.out.println("In PreDestroy: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15min.";
    }
}
