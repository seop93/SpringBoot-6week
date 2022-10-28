package com.example.hello.controller;


import com.example.hello.domain.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class GetController {
    @RequestMapping("/hello")
    public String hello() {
        log.info("hello 요청이 들어왔습니다.");
        return "Hello World";
    }

    @ApiOperation(value = "Get 메서드 예제", notes = "@RequestParam을 활용한 Get Method")
    @GetMapping(value = "/request1")
    public String getRequestParam(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이름", required = true)@RequestParam String email,
            @ApiParam(value = "이름", required = true)@RequestParam String organization
    ) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value = "/pathVariable1/{path}")
    public String getVariable1(@PathVariable String path){
        log.info("getVaiable1으로 요청이 들어왔습니다 . path:{}", path);
        return path;
    }

    @GetMapping(value = "/pathVariable2/{path}")
    public String getVariable2(@PathVariable("path") String paths){
        return paths;
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
