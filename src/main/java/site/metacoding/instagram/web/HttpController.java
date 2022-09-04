package site.metacoding.instagram.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // File을 응답하는 컨트롤러 (클라이언트가 브라우저면 .html파일을)
@RestController // 스프링이 컨트롤러로 만들어줌, Data를 응답하는 컨트롤러 (클라이언트가 핸드폰이면 data)
public class HttpController {

    // http://localhost:8080/get
    @GetMapping("/get")
    public String get() {
        return "<h1>get 요청됨</h1>"; // 데이터가 될 수도, 파일명이 될 수도 있다.
    }

    // http://localhost:8080/post
    @PostMapping("/post")
    public String post() {
        return "post 요청됨";
    }

    @PutMapping("/put")
    public String put() {
        return "put 요청됨";
    }

    @DeleteMapping("/delete")
    public String delete() {
        return "delete 요청됨";
    }
}
