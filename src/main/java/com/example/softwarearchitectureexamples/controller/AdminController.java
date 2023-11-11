package com.example.softwarearchitectureexamples.controller;

import com.example.softwarearchitectureexamples.dox.User;
import com.example.softwarearchitectureexamples.exception.XException;
import com.example.softwarearchitectureexamples.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    private final UserService userService;

    @GetMapping("users/{uid}")
    public Map<String, Object> getUser(@PathVariable int uid) {
        User user = userService.getUser(uid);
        if (user == null) {
            throw new XException("用户不存在");
        }
        return Map.of("user", user);
    }
}
