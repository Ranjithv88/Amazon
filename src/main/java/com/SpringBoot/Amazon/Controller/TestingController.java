package com.SpringBoot.Amazon.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class TestingController {

        @GetMapping("/test")
        public String test (){
            return " Testing Api .......!  ";
        }

}

