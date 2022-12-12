package com.example.threadbasic.controller;

import com.example.threadbasic.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asynService;

    @GetMapping("/async")
    @Async
    public void goAsync() throws Exception{
        /*for(int a = 0; a < 1000; a++){
            asynService.onAsync(a);
        }*/
        Thread.sleep(10000000);
        String str ="Hello World";
        //return str;
    }
}
