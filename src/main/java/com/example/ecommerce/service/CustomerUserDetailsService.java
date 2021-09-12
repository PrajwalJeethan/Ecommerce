/**
 * 
 */
package com.example.ecommerce.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.CustomerUserDetails;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.RoleRepository;
import com.example.ecommerce.repository.UserRepository;

/**
 * @author pmonthei
 *
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(()->new UsernameNotFoundException("User Not Found!"));
		return user.map(CustomerUserDetails:: new).get();
		
	}
	public User registerUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
		return user;
	}

}
