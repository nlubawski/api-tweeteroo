package com.tweeteroo.apitweeteroo.Model;

import com.tweeteroo.apitweeteroo.Dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UserModel {

  public UserModel(UserDTO user){
    this.username = user.username();
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
