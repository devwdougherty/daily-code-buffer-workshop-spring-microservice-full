package com.devwdougherty.user.service.controller;

import com.devwdougherty.user.service.VO.ResponseTemplateVO;
import com.devwdougherty.user.service.model.User;
import com.devwdougherty.user.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        userService.saveUser(user);

        log.info("Inside saveUser method of UserController");

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {

        log.info("Inside findUserById method of UserController");

        User user = userService.findByUserId(userId);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{userId}/departments")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable Long userId) {

        log.info("Inside getUserWithDepartment method of UserController");

        ResponseTemplateVO responseTemplateVO = userService.getUserWithDepartment(userId);

        return ResponseEntity.ok().body(responseTemplateVO);
    }
}

