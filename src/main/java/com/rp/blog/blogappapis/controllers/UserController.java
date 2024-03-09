package com.rp.blog.blogappapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rp.blog.blogappapis.payloads.UserDto;
import com.rp.blog.blogappapis.services.UserService;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
  {
    UserDto createdDto=this.userService.createUser(userDto);
    return new ResponseEntity<>(createdDto,HttpStatus.CREATED);
  }
  //post -create user
  //put -update user
  //DELETE -delete user
  //GET -user get
}
