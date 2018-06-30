package com.pollgen.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User")
public class UserEntity {
	@Id
	private String username;
	@Transient
	private String password;
	@CreationTimestamp
	@Column(updatable = false)
	private Date created;
	private String email;
	private String role;
	private boolean isActive;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}
}
