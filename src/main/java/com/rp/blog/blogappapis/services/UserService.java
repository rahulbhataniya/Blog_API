package com.rp.blog.blogappapis.services;

import com.rp.blog.blogappapis.payloads.UserDto;

import java.util.List;

public interface UserService {
  UserDto createUser(UserDto user);

  UserDto updateUser(UserDto user, Integer UserId);

  UserDto getUserById(Integer UserId);

  List<UserDto> getAllUser();

  void deleteUser(Integer UserId);

}
