package online.devplanet.spring_security_demo.Controller;

import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.model.User;
import online.devplanet.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    // create user
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    // get user
    @GetMapping("/users")
    public List<User> findAllUser() {
        return userService.finaAllUser();
    }

}
