/**
 * 
 */
package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.User;

/**
 * @author pmonthei
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findUserByEmail(String email);

}
