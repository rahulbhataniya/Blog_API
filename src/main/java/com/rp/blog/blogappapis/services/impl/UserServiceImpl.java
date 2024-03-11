package com.rp.blog.blogappapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.blog.blogappapis.exceptions.*;
import com.rp.blog.blogappapis.payloads.UserDto;
import com.rp.blog.blogappapis.services.UserService;
import com.rp.blog.blogappapis.repositories.*;
import com.rp.blog.blogappapis.entities.*;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;

  @Override
  public UserDto createUser(UserDto userDto) {
    // TODO Auto-generated method stub
    User user=this.dtoToUser(userDto);
    User savedUser=this.userRepo.save(user);
    return userToDto(savedUser);
  }

  @Override
  public void deleteUser(Integer UserId) {
    // TODO Auto-generated method stub
    User user=this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","id: ",UserId));
    this.userRepo.delete(user);
  }

  @Override
  public List<UserDto> getAllUser() {
    // TODO Auto-generated method stub
    List<User> users=this.userRepo.findAll();
    List<UserDto>userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
    return userDtos;
  }

  @Override
  public UserDto getUserById(Integer UserId) {
    // TODO Auto-generated method stub
    User user=this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","id: ",UserId));
    return this.userToDto(user);
  }

  @Override
  public UserDto updateUser(UserDto userDto, Integer UserId) {
    // TODO Auto-generated method stub
    User user=this.userRepo.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User","id: ",UserId));
    user.setName(userDto.getName());
    user.setAbout(userDto.getAbout());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    
    User updatedUser=this.userRepo.save(user);
    UserDto userDto1 =this.userToDto(updatedUser);
    return userDto1;
  }

  private User dtoToUser(UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setName(userDto.getName());
    user.setAbout(userDto.getAbout());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    return user;
  }

  private UserDto userToDto(User user) {
    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setAbout(user.getAbout());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    return userDto;
  }

}
