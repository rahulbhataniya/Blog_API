package com.rp.blog.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rp.blog.blogappapis.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
  
}
