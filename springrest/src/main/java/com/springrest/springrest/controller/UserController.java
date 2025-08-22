package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.dao.UserDao;
import com.springrest.springrest.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userDao.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userDao.getById(id);
	}

}
