package com.tweeteroo.apitweeteroo.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.apitweeteroo.Dto.TweetDTO;
import com.tweeteroo.apitweeteroo.Model.TweetCompleteModel;
import com.tweeteroo.apitweeteroo.Model.TweetModel;
import com.tweeteroo.apitweeteroo.Service.TweetService;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
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
    public ResponseEntity<List<TweetCompleteModel>> getTweetByUsername(@PathVariable String username) {
      var tweets = service.getTweetByUsername(username);
      if(tweets != null){
        return ResponseEntity.ok().body(tweets);
      }else{
        return ResponseEntity.notFound().build();
      }
  }

  @GetMapping()
  public Page<TweetCompleteModel> getTweets(@PageableDefault(page = 0, size = 5) Pageable page) {
    return service.getTweets(page);
  }
  
}
