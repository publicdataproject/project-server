package com.data.dataproject.dto.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class LoginDto {

    @ApiModelProperty(notes = "토큰값")
    private String token;

    @ApiModelProperty(notes = "유저 id값")
    private Long userId;
}
