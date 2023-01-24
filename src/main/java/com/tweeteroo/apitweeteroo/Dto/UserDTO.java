package com.tweeteroo.apitweeteroo.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(

  @NotBlank String username,

  @NotBlank String avatar

)
{

}
