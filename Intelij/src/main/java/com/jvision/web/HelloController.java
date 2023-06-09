package com.jvision.web;

import com.jvision.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러란 중간제어자를 의미함(MVC-Controller)
// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
// (JSON : JavaScript Object Notation)
@RestController
public class HelloController {
    // HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 줌
    // /hello로 요청이 오면 문자열 hello를 반환하는 기능
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequsetParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    // 외부에서 name(@RequestParam("name"))이란 이름으로 넘긴 파라미터를 메소드 파라미터
    // name(String name)에 저장하게 된다.
    public HelloResponseDto hellodto(@RequestParam("name") String name, @RequestParam("amount") int amount,
                                     @RequestParam("address") String address){
        return new HelloResponseDto(name, amount, address);
    }
}
