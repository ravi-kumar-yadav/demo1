package com.ravi.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class DemoController {

    private Coach coach;

//    Constructor Injection
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("In Constructor: " + getClass().getSimpleName());
        coach = theCoach;
    }

    /*
        Setter Injection
        any name could be given to method eg: setCoach or doSomeStuff
        just Annotate with @Autowired
     */
//    public DemoController(){
//        System.out.println("In Constructor: " + getClass().getSimpleName());
//    }
//
//    @Autowired
//    public void doSomeStuff(@Qualifier("cricketCoach")Coach theCoach){
//        coach = theCoach;
//    }

    @GetMapping("/")
    public String getDailyWorkout(){
        System.out.println("In method getDailyWorkout");
        return coach.getDailyWorkout();
    }
}
