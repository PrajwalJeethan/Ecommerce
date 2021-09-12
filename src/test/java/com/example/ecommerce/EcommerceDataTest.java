package com.example.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.ecommerce.model.Role;
import com.example.ecommerce.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class EcommerceDataTest {
	
	@Autowired
	private RoleRepository roleRepository;
	@Test
	void insertDefaultRoles() {
		List<String> roleNames = new ArrayList<>();
		roleNames.add("ROLE_ADMIN");
		roleNames.add("ROLE_USER");
		
		List<Role> roles = new ArrayList<>();
		roleNames.forEach(name ->{
			Role role = new Role();
			role.setName(name);
			roles.add(role);
		});
		roleRepository.saveAll(roles);
	}

}
