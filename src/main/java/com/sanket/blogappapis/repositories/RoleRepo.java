package com.sanket.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.blogappapis.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
