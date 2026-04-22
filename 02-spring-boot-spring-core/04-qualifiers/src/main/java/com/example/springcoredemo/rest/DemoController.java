package com.example.springcoredemo.rest;

import com.example.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;

    //setter injection
    /*
    Önce Spring boş nesneyi oluşturur
    Sonra setter methodunu çağırır
    Dependency daha sonra eklenir

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach = theCoach;
    }

     */

    //constructor injection daha çok tercih edlir. Çünkü Spring objeyi oluştururken coach dependency'i aynı anda verir.
    //Nesne + dependency birlikte oluşturulur
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        myCoach = theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
