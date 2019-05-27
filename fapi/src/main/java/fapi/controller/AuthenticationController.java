package fapi.controller;

import fapi.models.AuthToken;
import fapi.models.User;
import fapi.security.TokenProvider;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

//AuthenticationController has API exposed to generate JWT token
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User user){
        try {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getLogin(),
                        user.getPassword()
                )
        );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = tokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));
        }catch (ExpiredJwtException | BadCredentialsException ex){
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }
}
