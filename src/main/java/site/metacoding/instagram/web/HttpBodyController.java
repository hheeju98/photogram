package site.metacoding.instagram.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import site.metacoding.instagram.domain.User;

@RestController
public class HttpBodyController {

    @PostMapping("/body1")
    public String xwwwformurlencoded(String username) {
        return "key=value 전송옴";
    }

    @PostMapping("/body2")
    public String plaintext(@RequestBody String data) { // 평문: 안녕
        return "text/plain 전송옴";
    }

    @PostMapping("/body3")
    public String applicationjson(@RequestBody String data) {
        return "json 전송옴";
    }

    @PostMapping("/body4")
    public String applicationjsonToObject(@RequestBody User user) {
        return "json 전송옴";
    }
}
