package com.tweeteroo.apitweeteroo.Service;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweeteroo.apitweeteroo.Dto.TweetDTO;
import com.tweeteroo.apitweeteroo.Model.TweetCompleteModel;
import com.tweeteroo.apitweeteroo.Model.TweetModel;
import com.tweeteroo.apitweeteroo.Model.UserModel;
import com.tweeteroo.apitweeteroo.Repository.TweetRepository;

@Service
public class TweetService {

  @Autowired
  private TweetRepository repository;

  @Autowired
  private UserService service;

  public void save(@RequestBody TweetDTO req) {
    repository.save(new TweetModel(req));
  }

  public List<TweetCompleteModel> getTweetByUsername(String usernameAux){
    List<TweetModel> tweets =  repository.findAll();
    var tweetsUser = new ArrayList<TweetModel>();
    tweets.forEach(tweet -> {
      if(tweet.getUsername().equals(usernameAux)){
        tweetsUser.add(tweet);
      }
    }); 
    String userAvatar = service.getAvatar(usernameAux);
    var tweetsWithAvatar = new ArrayList<TweetCompleteModel>();
    tweetsUser.forEach(
        item -> {
            String tweet = item.getTweet();
            String username = item.getUsername();
            String avatar = userAvatar;
            TweetCompleteModel tweetsAux = new TweetCompleteModel(           
            username,                
            tweet,
            avatar);
          tweetsWithAvatar.add(tweetsAux);
        }
      );
    return tweetsWithAvatar;
  }

  public Page<TweetCompleteModel> getTweets(Pageable pageable){
    int page = Integer.parseInt(pageable.getPageParameter());
    int size = Integer.parseInt(pageable.getSizeParameter());
    PageRequest pageRequest = PageRequest.of(
      page,
      size
    );

    List<TweetModel> tweets =  repository.findAll();
    List<UserModel> users = service.getAllUsers();
    var tweetsWithAvatar = new ArrayList<TweetCompleteModel>();
    tweets.forEach(item ->{
      String userAvatar = service.getAvatar(item.getUsername());
      String tweet = item.getTweet();
      String username = item.getUsername();
      String avatar = userAvatar;
      TweetCompleteModel tweetsAux = new TweetCompleteModel(           
      username,                
      tweet,
      avatar);
      tweetsWithAvatar.add(tweetsAux);
    });

      return new PageImpl<>(
      tweetsWithAvatar,
      pageRequest,size);
  }
}
