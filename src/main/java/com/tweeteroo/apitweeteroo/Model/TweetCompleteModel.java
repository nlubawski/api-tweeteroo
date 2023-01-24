package com.tweeteroo.apitweeteroo.Model;

import com.tweeteroo.apitweeteroo.Dto.TweetCompleteDTO;

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
public class TweetCompleteModel {
  public TweetCompleteModel(String username, String tweet, String avatar){
    this.username = username;
    this.tweet = tweet;
    this.avatar = avatar;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String tweet;

  @Column(length = 200, nullable = false)
  private String avatar;
}
