package com.example.togather.domain.user.controller;

import com.example.togather.domain.user.dto.UserDto;
import com.example.togather.domain.user.entity.User;
import com.example.togather.domain.user.service.UserService;
import com.example.togather.global.dto.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "유저를 생성합니다.", description = "유저를 생성합니다.")
    @PostMapping("/create/{meeting_id}")
    public ResponseEntity<ResponseDto<UserDto>> createUser(@RequestBody UserDto userDto,
                            @PathVariable("meeting_id")UUID uuid) {
        userService.createUser(userDto, uuid);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK,"유저 등록 성공", userDto),HttpStatus.OK);
    }


}
