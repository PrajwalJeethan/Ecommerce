/**
 * 
 */
package com.example.ecommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author pmonthei
 *
 */
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@SequenceGenerator(name="role_seq",
						sequenceName="role_seq",
						allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="role_seq")
	@Column(name="role_id")
	private Long roleId;
	@NotEmpty
	@Column(nullable=false, unique=true)
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	

}
