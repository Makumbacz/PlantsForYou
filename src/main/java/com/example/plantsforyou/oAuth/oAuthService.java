package com.example.plantsforyou.oAuth;

import com.example.plantsforyou.appuser.AppUser;
import com.example.plantsforyou.appuser.AppUserRole;
import com.example.plantsforyou.appuser.AppUserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Optional;

@Service
public class oAuthService {
    private AppUserService userService;

    @Autowired
    private void setUserService(AppUserService userService){
        this.userService = userService;
    }

    public GoogleIdToken validate(String token) throws GeneralSecurityException, IOException {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                    .setAudience(Collections.singletonList("676799456601-hu3k0k4ko7h7s52t8p7quk7kqho87umb.apps.googleusercontent.com"))
                    .build();
            return verifier.verify(token);
        }
        catch (GeneralSecurityException | IOException e){
            return null;
        }
    }
    public Optional<AppUser> findByEmail(String email){ return Optional.ofNullable(userService.getAppUser(email)); }

    public void singUpUser(GoogleIdToken.Payload payload){
        AppUser user = new AppUser((String) payload.get("name"), (String) payload.get("family_name"), payload.getEmail(), AppUserRole.USER);
        userService.signUpUser(user);
    }
}
