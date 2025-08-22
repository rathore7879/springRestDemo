package com.springrest.springrest.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	private UserProfile userProfile;
	
	public User() {
		super();
	}


	public User(Long id, String username, UserProfile userProfile) {
		super();
		this.id = id;
		this.username = username;
		this.userProfile = userProfile;
	}


	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}




}
