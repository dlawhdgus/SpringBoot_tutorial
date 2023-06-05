package com.example.testproject.controller;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController  //컨트롤러로 사용한다라고 명시
@RequestMapping(value = "/api/v1")
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("log-test")
    public void logTest() {
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }

    @PostMapping("/exception")
    public void exception() throws Exception {
        throw new Exception();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code","400");
        map.put("message","에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }



}
