/**
 * 
 */
package com.example.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Entity class for User object
 * @author pmonthei
 *
 */
@Entity
@Table(name="users")
public class User {
	@Id
	@SequenceGenerator(name="user_seq",
						sequenceName="user_seq",
						allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
	@Column(name="user_id")
	private Long userId;
	@NotEmpty
	@Column(name="first_name",nullable=false)
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@NotEmpty
	@Column(nullable=false, unique=true)
	@Email(message="{error.invalid_email}")
	private String email;
	
	private String password;
	
	@ManyToMany(cascade= CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns = {@JoinColumn(name="user_id",referencedColumnName="user_id")},
			inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName="role_id")}
			)
	private List<Role> roles;
	
	
	
	public User() {
		
	}

	public User(User user) {
		super();
		this.userId = user.getUserId();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = user.getRoles();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
