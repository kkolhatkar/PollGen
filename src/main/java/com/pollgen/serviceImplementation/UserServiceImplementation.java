package com.pollgen.serviceImplementation;

import com.pollgen.entity.UserEntity;
import com.pollgen.repository.UserRepository;
import com.pollgen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void create(UserEntity user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	@Transactional
	public UserEntity findByUsername(String username) {
		return userRepository.findById(username).orElseThrow(
				() -> new UsernameNotFoundException(" doesn't exist."));
	}
}
