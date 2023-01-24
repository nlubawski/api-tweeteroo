package com.tweeteroo.apitweeteroo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity 
public class UserModel {
  
  @Column(length = 200, nullable = false)
  private String name;

  @Column(length = 200, nullable = false)
  private String avatar;
}
