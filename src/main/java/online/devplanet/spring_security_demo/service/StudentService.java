package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.StudentRepo;
import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.config.UserAuthenticationToken;
import online.devplanet.spring_security_demo.model.Student;
import online.devplanet.spring_security_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    public List<Student> getAllStudent() {
        UserAuthenticationToken userAuthenticationToken= (UserAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String userId = userAuthenticationToken.getUserId();

        return studentRepo.findAllByUser_UserId(UUID.fromString(userId));
    }

    public Student add(Student student) {
        // Get the authenticated user details
        UserAuthenticationToken userAuthenticationToken =
                (UserAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        String userId = userAuthenticationToken.getUserId();

        // Fetch the User entity from the database
        User user = userRepo.findByUserId(UUID.fromString(userId));

        // Set the user in the student entity
        student.setUser(user);

        // Save the student entity
        return studentRepo.save(student);
    }


}
