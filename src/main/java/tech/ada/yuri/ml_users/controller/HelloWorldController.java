package tech.ada.yuri.ml_users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @PostMapping
    public String sayHello() {
        return "Hello";
    }

    //o site pega por padrao o get
    @GetMapping
    public String hello() {
        return "Hello World";
    }



    //getmapping, postmapping, putmapping, tudo para os verbos http


}
