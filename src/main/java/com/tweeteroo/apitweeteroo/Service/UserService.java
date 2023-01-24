package com.tweeteroo.apitweeteroo.Service;

import java.util.ArrayList;
import java.util.List;
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

  public String getAvatar(String username) {
    List<UserModel> users = repository.findAll();
    List<UserModel> userSelected = new ArrayList<UserModel>();
    users.forEach(user -> {
      if(user.getUsername().equals(username)){
        userSelected.add(user);
      }
    }); 
    return userSelected.get(0).getAvatar();
  }

  public List<UserModel> getAllUsers(){
    return repository.findAll();
  }
}
