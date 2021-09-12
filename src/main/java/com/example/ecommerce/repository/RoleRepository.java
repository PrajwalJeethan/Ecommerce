/**
 * 
 */
package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Role;

/**
 * @author pmonthei
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String string);
	
	

}
