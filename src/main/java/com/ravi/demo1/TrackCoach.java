package com.ravi.demo1;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Practice slow running for 15min!!!";
    }
}
