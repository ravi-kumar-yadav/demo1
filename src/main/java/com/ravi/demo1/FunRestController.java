package com.ravi.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${project.name}")
    private String projectName;

    @Value("${project.country}")
    private String projectCountry;

    @GetMapping("/")
    public String getMethod(){
        System.out.println("Project Name: " + projectName + ", Project Country: " + projectCountry);
        return "Hello World!!!";
    }
}
