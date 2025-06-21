package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.startup.Bootstrap;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path="/hello")
    public String hello(){
        var html = "<html><body><h1>Hello Spring Boot</h1></body></html>";
//        return "Hello Spring Boot";
        return html;
    }

    @GetMapping(path="/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
//      @PathVariable String message
        @PathVariable(name="message") String msg,
        @PathVariable int age,
        @PathVariable boolean isMan
    ){
        System.out.println("echo message: " + msg);
        System.out.println("echo message: " + age);
        System.out.println("echo message: " + isMan);
        //TODO 대문자로 변환해서 RETURN
        //String 타입의 변수 외에 다른 타입 받아보기
        return msg;
    }
    //http://localhost:8081/api/book?category=IT&issueYear=2023&issued-month=01&issued_day=31
    @GetMapping(path="/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issueYear,
            @RequestParam(name="issued-month") String issuedMonth,
            @RequestParam(name="issued-day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issueYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }
    @GetMapping(path="/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }
    //TODO Parameter 2가지 받습니다. int형태로 받아서 두 수의 뎃셈, 곱셈
    //TODO String 타입 boolean 타입도 받아보기
    @DeleteMapping(path=
            {"/user/{userName}/delete",
                    "user/{userName}/del"}
    )
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name: {}", userName);
    }
}
