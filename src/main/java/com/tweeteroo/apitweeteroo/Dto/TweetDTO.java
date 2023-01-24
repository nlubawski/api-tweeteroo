package com.tweeteroo.apitweeteroo.Dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
  
  @NotBlank String username,

  @NotBlank String tweet) {
  
}
