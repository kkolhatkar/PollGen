package com.pollgen.serviceImplementation;

import com.pollgen.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	private UserServiceImplementation userServiceImplementation;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = this.userServiceImplementation.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " does not exists");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
		grantList.add(authority);
		return (UserDetails) new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, grantList);
	}

}