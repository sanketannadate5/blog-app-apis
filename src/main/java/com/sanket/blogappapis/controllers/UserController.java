package com.sanket.blogappapis.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.blogappapis.payloads.UserDto;
import com.sanket.blogappapis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST - create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto userDto) {
		UserDto createUserDto = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
	}

	// PUT - update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Long userId) {
		UserDto updatedUserDto = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUserDto);
	}

	// DELETE - delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("userId") Long userId){
		userService.DeleteUser(userId);
		return ResponseEntity.ok(Map.of("Message ","The Use is deleted "+userId));
	}

	// GET - get User
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getUsers(){
		List<UserDto> userDtos=userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK);
	}
}
