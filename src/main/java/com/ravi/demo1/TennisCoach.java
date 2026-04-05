package com.ravi.demo1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return "Practice forehand for 15min!!!";
    }
}
