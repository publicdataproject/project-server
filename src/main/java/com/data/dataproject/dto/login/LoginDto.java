package com.data.dataproject.dto.login;

import com.data.dataproject.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String token;
    private Long id;
}
