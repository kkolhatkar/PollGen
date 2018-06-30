package com.pollgen.serviceImplementation;

import com.pollgen.entity.UserEntity;
import com.pollgen.repository.UserRepository;
import com.pollgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void create(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		//int active = user.getActive()? 1:0;
		//user.setActive(active);
		userRepository.save(user);
	}

	@Override
	public String read(String username) {
		UserEntity userEntity = userRepository.getOne(username);
		return userEntity.getEmail();
	}
}
