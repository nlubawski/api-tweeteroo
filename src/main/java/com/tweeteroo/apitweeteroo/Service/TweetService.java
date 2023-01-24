package com.tweeteroo.apitweeteroo.Service;

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
}
