package com.tweeteroo.apitweeteroo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.apitweeteroo.Dto.TweetDTO;
import com.tweeteroo.apitweeteroo.Model.TweetModel;
import com.tweeteroo.apitweeteroo.Service.TweetService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/tweets")
public class TweetController {
  
  @Autowired
  private TweetService service;

  @ResponseStatus(code = HttpStatus.CREATED) 
  @PostMapping
    public void create(@RequestBody TweetDTO req) {
      service.save(req);
  }

  @ResponseStatus(code = HttpStatus.OK) 
  @GetMapping("/{username}")
    public List<TweetModel> getTweetByUsername(@PathVariable String username) {
      return service.getTweetByUsername(username);
  }
}
