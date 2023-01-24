package com.tweeteroo.apitweeteroo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.apitweeteroo.Dto.UserDTO;
import com.tweeteroo.apitweeteroo.Service.UserService;

@RestController
@RequestMapping("api/sign-up")
public class UserController {
  
  @Autowired
  private UserService service;

  @PostMapping
    public void create(@RequestBody UserDTO req) {
    service.save(req);
  }
}
