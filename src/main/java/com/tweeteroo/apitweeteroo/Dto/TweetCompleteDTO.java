package com.tweeteroo.apitweeteroo.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record TweetCompleteDTO(

  @NotBlank String username,

  @NotBlank String avatar,

  @NotBlank String tweet

)
{

}
