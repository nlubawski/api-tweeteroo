package com.tweeteroo.apitweeteroo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweeteroo.apitweeteroo.Dto.UserDTO;
import com.tweeteroo.apitweeteroo.Model.UserModel;
import com.tweeteroo.apitweeteroo.Repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  public void save(@RequestBody UserDTO req) {
    repository.save(new UserModel(req));
  }
}
