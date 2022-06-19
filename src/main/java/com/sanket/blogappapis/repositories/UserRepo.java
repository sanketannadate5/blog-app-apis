package com.sanket.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
