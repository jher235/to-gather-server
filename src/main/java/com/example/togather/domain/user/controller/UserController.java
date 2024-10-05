package com.example.togather.domain.user.controller;

import com.example.togather.domain.user.dto.UserDto;
import com.example.togather.domain.user.entity.User;
import com.example.togather.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "유저를 생성합니다.", description = "유저를 생성합니다.")
    @PostMapping("/create")
    public User createUser(@RequestBody UserDto userDto, UUID uuid) {
        return userService.createUser(userDto);
    }

}
