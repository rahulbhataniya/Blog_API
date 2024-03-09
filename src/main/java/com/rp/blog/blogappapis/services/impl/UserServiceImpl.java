package com.rp.blog.blogappapis.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rp.blog.blogappapis.payloads.UserDto;
import com.rp.blog.blogappapis.services.UserService;
import com.rp.blog.blogappapis.repositories.*;
import com.rp.blog.blogappapis.entities.*;

public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepo userRepo; 

  @Override
  public UserDto createUser(UserDto user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteUser(Integer UserId) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<UserDto> getAllUser() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserDto getUserById(Integer UserId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserDto updateUser(UserDto user, Integer UserId) {
    // TODO Auto-generated method stub
    return null;
  }

  private User dtoToUser(UserDto userDto)
  {
    User user=new User();
    user.setId(userDto.getId());
    user.setName(userDto.getName());
    user.setAbout(userDto.getAbout());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    return user;
  }

  private UserDto userToDto(User user)
  {
    UserDto userDto=new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setAbout(user.getAbout());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    return userDto;
  }
  
}
