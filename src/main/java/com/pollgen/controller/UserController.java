package com.pollgen.controller;

import com.pollgen.entity.UserEntity;
import com.pollgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "p")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "register")
	public void create(@RequestBody UserEntity userEntity) {
		userService.create(userEntity);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "{username}")
	public String read(@PathVariable("username") String username) {
		return userService.read(username);
	}

}
