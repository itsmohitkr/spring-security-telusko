package online.devplanet.spring_security_demo.service;

import online.devplanet.spring_security_demo.Repo.StudentRepo;
import online.devplanet.spring_security_demo.Repo.UserRepo;
import online.devplanet.spring_security_demo.model.Student;
import online.devplanet.spring_security_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    public List<Student> getAllStudent(Authentication authentication) {
        String userName = authentication.getName();
        User user = userService.getUserByUsername(userName); // Fetch the User entity
        return studentRepo.findAllByUser(user); // Query using the User entity
    }

    public Student add(Student student, Authentication authentication) {
        System.out.println("called");
        String userName= authentication.getName();

        student.setUser(userRepo.findByUsername(userName));
        return studentRepo.save(student);
    }

}
