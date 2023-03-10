package com.example.demo.payload.response;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private Integer id;
    private String token;
    private String type = "Bearer";
    private String name;
    private Collection<? extends GrantedAuthority> roles;


    public JwtResponse(String token, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = username;
        this.roles = roles;
    }
}
