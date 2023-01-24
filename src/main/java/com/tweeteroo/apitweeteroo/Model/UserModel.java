package com.tweeteroo.apitweeteroo.Model;

import com.tweeteroo.apitweeteroo.Dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity 
public class UserModel {

  public UserModel(UserDTO user){
    this.username = user.name();
    this.avatar = user.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(length = 200, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String avatar;
}
