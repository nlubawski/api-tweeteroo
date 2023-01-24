package com.tweeteroo.apitweeteroo.Dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(

  @NotBlank String name,

  @NotBlank String avatar

)
{

}