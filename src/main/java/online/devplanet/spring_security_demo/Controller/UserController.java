package online.devplanet.spring_security_demo.Controller;

import jakarta.servlet.http.HttpServletResponse;
import online.devplanet.spring_security_demo.model.User;
import online.devplanet.spring_security_demo.service.JwtService;
import online.devplanet.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    // create user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    // for login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        // get userid from authentication

        if (authentication.isAuthenticated()){
            User userFromDb = userService.getUserByUsername(user.getUsername());
            String jwtToken= jwtService.generateToken(userFromDb.getUsername(), userFromDb.getUserId());
            ResponseCookie cookie =ResponseCookie.from("JWT-TOKEN", jwtToken)
                    .httpOnly(true)
                    .secure(true)
                    .path("/")
                    .maxAge(60*60*24*15)
                    .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok("login Successful! Jwt stored in cookie");
        }

        return ResponseEntity.status(401).body("Login failed");
    }

}
