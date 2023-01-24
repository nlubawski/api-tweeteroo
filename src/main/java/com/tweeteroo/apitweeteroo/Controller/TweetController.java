package com.tweeteroo.apitweeteroo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.apitweeteroo.Dto.TweetDTO;
import com.tweeteroo.apitweeteroo.Service.TweetService;

@RestController
@RequestMapping("api/tweets")
public class TweetController {
  
  @Autowired
  private TweetService service;

  @ResponseStatus(code = HttpStatus.CREATED) 
  @PostMapping
    public void create(@RequestBody TweetDTO req) {
      
  }
}
