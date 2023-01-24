package com.tweeteroo.apitweeteroo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweeteroo.apitweeteroo.Dto.TweetDTO;
import com.tweeteroo.apitweeteroo.Model.TweetModel;
import com.tweeteroo.apitweeteroo.Repository.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository repository;

  public void save(@RequestBody TweetDTO req) {
    repository.save(new TweetModel(req));
  }

  public List<TweetModel> getTweetByUsername(String username){
    List<TweetModel> tweets =  repository.findAll();
    List<TweetModel> tweetsUser = new ArrayList<TweetModel>();
    tweets.forEach(tweet -> {
      if(tweet.getUsername().equals(username)){
        tweetsUser.add(tweet);
      }
    }); 
    return tweetsUser;    
  }
}
