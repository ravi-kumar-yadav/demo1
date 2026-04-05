package com.ravi.demo1;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Play Volley for 15min!!!";
    }
}
