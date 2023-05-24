package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //http://localhost:9090/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World";
    }

    //http://localhost:9090/api/v1/post-api/member
    //body value -> JSON 형태로 전송
    //{
    //  "name":"dlawhdgus",
    //  "email":"ovioivo@naver.com",
    //  "organization":"school"
    //}
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:9090/api/v1/post-api/member2
    //body value
    // {
    //  "name":"dlawhdgus",
    //  "email":"ovioivo@naver.com",
    //  "organization":"school"
    //}
    //return value
    //MemberDTO{name='dlawhdgus', email='ovioivo@naver.com', organization='school'}
    @PostMapping(value = "/member2")
    public String postMemberDTO(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }

}
