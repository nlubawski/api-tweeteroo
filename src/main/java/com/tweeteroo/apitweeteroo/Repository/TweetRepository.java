package com.tweeteroo.apitweeteroo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.apitweeteroo.Model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
  
}
