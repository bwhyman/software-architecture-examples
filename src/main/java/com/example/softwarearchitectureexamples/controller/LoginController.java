package com.example.softwarearchitectureexamples.controller;

import com.example.softwarearchitectureexamples.dox.User;
import com.example.softwarearchitectureexamples.exception.XException;
import com.example.softwarearchitectureexamples.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
@Slf4j
public class LoginController {
    private final UserService userService;

    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User u, HttpServletResponse response) {
        log.debug("{}", u);
        User user = userService.getUser(u.getAccount(), u.getPassword());
        if (user == null) {
            throw new XException("账户密码错误");
        }
        // 实际开发应基于JWT等规范，将用户实际权限/ID等敏感信息加密生成token令牌在header返给前端
        // 前端在每次请求时携带token校验
        response.addHeader("role", user.getRole().toString());
        response.addHeader("uid", user.getId().toString());

        return  Map.of("user", user);
    }

}
