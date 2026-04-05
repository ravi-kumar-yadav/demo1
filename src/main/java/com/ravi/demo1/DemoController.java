package com.ravi.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;

//    Constructor Injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        this.coach = theCoach;
//    }

//    Setter Injection
//    any name could be given to method eg: setCoach or doSomeStuff
//    just Annotate with @Autowired
    @Autowired
    public void doSomeStuff(Coach theCoach){
        coach = theCoach;
    }

    @GetMapping("/")
    public String getDailyWorkout(){
        System.out.println("In method getDailyWorkout");
        return coach.getDailyWorkout();
    }
}
