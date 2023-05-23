package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        return "dlawhdgus";
    }

    //http://localhost:8080/api/v1/get-api/variable1/{String}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable) {
        return variable;
    }
    //http://localhost:8080/api/v1/get-api/variable2/{string}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return  var;
    }

    // http://localhost:8080/api/v1/get-api/request1?
    // name=dlawhdgus&
    // email=ovioivo@naver.com&
    // organization=school
    @GetMapping(value = "/request1")
    public String getParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    //key1 : value1
    //key2 : value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }
    //http://localhost:8080/api/v1/get-api/request3?name=dlawhdgus&email=ovioivo@naver.com&organization=school
    //값 : MemberDTO{name='dlawhdgus', email='ovioivo@naver.com', organization='school'}
    @GetMapping(value = "request3")
    public String getRequestParam3(MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
