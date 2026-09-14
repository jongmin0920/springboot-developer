package me.jmlee.springdeveloper;

import org.springframework.web.bind.annotation.*;

// 컨트롤러 클래스
@RestController
public class HelloWorldController {

    // "/hello" 요청을 보내면 hello() 메서드 호출
    // http://localhost:8888/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    //http://localhost:8080/test -> "Hello Everyone!!!!"
    @GetMapping("/test")
    public String test() {
        return "Hello Everyone!!!!";
    }

    @PostMapping ("/test")
    public String PostTest() { return "Post Test response!!!!!!!"; }

    @DeleteMapping ("/test")
    public String DeleteTest() {
        return "Delete Test response!!!!!!!";
    }

    @PutMapping ("/test")
    public String PutTest() {
        return "Put Test response!!!!!!!";
    }
}