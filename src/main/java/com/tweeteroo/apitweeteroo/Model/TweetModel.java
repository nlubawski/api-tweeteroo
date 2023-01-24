package com.tweeteroo.apitweeteroo.Model;
import com.tweeteroo.apitweeteroo.Dto.TweetDTO;

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
public class TweetModel {
  public TweetModel(TweetDTO tweet){
    this.username = tweet.username();
    this.tweet = tweet.tweet();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String tweet;
}
