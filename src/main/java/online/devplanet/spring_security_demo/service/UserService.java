package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }


    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    public int getUserIdByUsername(String username) {

        return userRepo.findUserIdByUsername(username);

    }

    public User getUserByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }
}
