package com.sanket.blogappapis.services;

import java.util.List;

import com.sanket.blogappapis.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Long id);

	UserDto getUserById(Long userId);

	List<UserDto> getAllUsers();

	void deleteUser(Long userId);

}
