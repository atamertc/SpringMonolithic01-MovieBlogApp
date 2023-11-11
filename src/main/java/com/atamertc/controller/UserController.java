package com.atamertc.controller;

import com.atamertc.dto.request.UserLoginRequestDto;
import com.atamertc.dto.request.UserSaveRequestDto;
import com.atamertc.dto.response.UserLoginResponseDto;
import com.atamertc.dto.response.UserSaveResponseDto;
import com.atamertc.repository.entity.User;
import com.atamertc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.atamertc.constant.EndPoints.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserSaveResponseDto> createUser(@Valid @RequestBody UserSaveRequestDto dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto dto) {
        return ResponseEntity.ok(userService.loginUser(dto));
    }

    @GetMapping("/containsname")
    public ResponseEntity<List<UserLoginResponseDto>> findAllUserNameContains(String value) {
        return ResponseEntity.ok(userService.findAllUserNameContains(value));
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> findAllByOrderByName() {
        return ResponseEntity.ok(userService.findAllByOrderByName());
    }

    @GetMapping("/emailendingwith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value) {
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }

    @GetMapping("/passwordlongerthan")
    public ResponseEntity<List<User>> findAllByPasswordLongerThan(Integer sayi) {
        return ResponseEntity.ok(userService.findAllByPasswordLongerThan(sayi));
    }

    @GetMapping("/passwordlongerthan2")
    public ResponseEntity<List<User>> findAllByPasswordLongerThan2(Integer sayi) {
        return ResponseEntity.ok(userService.findAllByPasswordLongerThan2(sayi));
    }

    @GetMapping("/passwordlongerthan3")
    public ResponseEntity<List<User>> findAllByPasswordLongerThan3(Integer sayi) {
        return ResponseEntity.ok(userService.findAllByPasswordLongerThan3(sayi));
    }

}
