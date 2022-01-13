package com.darlingof02.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://todo-demo-frontend.s3-website.us-east-2.amazonaws.com", "http://localhost:4200/"})
public class HelloWorldController {
    //get
    //URI -/hello-word
    //method - "hello world
    @GetMapping(path="/hello-world")
    public String hello() {
        return "Hello World";
    }

    //hello-world-bean
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");

    }

    //hello-world-bean/path-variable/darlingof02
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
//        throw new RuntimeException("Something went wrong");
        return new HelloWorldBean(String.format("Hello World dummy, %s", name));

    }
}
