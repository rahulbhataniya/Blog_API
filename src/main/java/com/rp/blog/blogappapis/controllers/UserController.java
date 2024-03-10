package com.rp.blog.blogappapis.controllers;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rp.blog.blogappapis.payloads.ApiResponse;
import com.rp.blog.blogappapis.payloads.UserDto;
import com.rp.blog.blogappapis.services.UserService;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




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

  @PutMapping("/{userId}")
  public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {
      //TODO: process PUT request is used to update existing record 
      UserDto updaUserDto=this.userService.updateUser(userDto, userId);
      return ResponseEntity.ok(updaUserDto);
  }

  @DeleteMapping("/{UserId}")
  public ResponseEntity<?>deleteUser(@PathVariable Integer UserId)
  {
    this.userService.deleteUser(UserId);
    return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
  }

  //GET -user get

  @GetMapping("/")
  public ResponseEntity<List<UserDto>>getAllUsers() {
      return ResponseEntity.ok(this.userService.getAllUser());
  }

  @GetMapping("/{UserId}")
  public ResponseEntity<UserDto>getSingleUser(@PathVariable Integer UserId) {
      return ResponseEntity.ok(this.userService.getUserById(UserId));
  }
  
}
