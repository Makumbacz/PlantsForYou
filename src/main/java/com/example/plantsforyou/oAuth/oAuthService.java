package com.example.plantsforyou.oAuth;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserRepository;
import com.example.plantsforyou.appuser.AppUserRole;
import com.example.plantsforyou.filter.CustomAuthenticationFilter;
import com.example.plantsforyou.appuser.AppUserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

@Service
public class oAuthService {
    HttpTransport transport;
    JsonFactory factory;
    AppUserService userService;

    public GoogleIdToken validate(String token) throws GeneralSecurityException, IOException {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, factory)
                    .setAudience(Collections.singletonList("676799456601-hu3k0k4ko7h7s52t8p7quk7kqho87umb.apps.googleusercontent.com"))
                    .build();
            return verifier.verify(token);
        }
        catch (GeneralSecurityException | IOException e){
            return null;
        }
    }
    public UserDetails findByEmail(String email){ return userService.loadUserByUsername(email); }

    public void singUpUser(GoogleIdToken.Payload payload){
        AppUser user = new AppUser((String) payload.get("name"), (String) payload.get("family_name"), payload.getEmail(), AppUserRole.USER);
        userService.signUpUser(user);
    }
}
