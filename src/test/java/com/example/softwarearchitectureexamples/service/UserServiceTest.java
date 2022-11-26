package com.example.softwarearchitectureexamples.service;

import com.example.softwarearchitectureexamples.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;
}
