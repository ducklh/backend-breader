package com.example.demo.payload.request;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    private String accountName;
    private String password;
    private String email;
    private String resetPasswordToken;

    public LoginRequest(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

}
