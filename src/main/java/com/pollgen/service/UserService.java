package com.pollgen.service;

import com.pollgen.entity.UserEntity;

public interface UserService {
	public void create(UserEntity user);

	public String read(String username);
}
