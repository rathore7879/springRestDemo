package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.UserProfile;

public interface UserProfileDao extends JpaRepository<UserProfile, Long> {

}
