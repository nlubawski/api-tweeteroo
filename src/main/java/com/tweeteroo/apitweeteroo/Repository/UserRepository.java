package com.tweeteroo.apitweeteroo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.apitweeteroo.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
  
}
