package com.example.plantsforyou.appuser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCredentials {
    private String username;
    private String password;
    private String oauth;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getOAuth() { return oauth;  }
}
