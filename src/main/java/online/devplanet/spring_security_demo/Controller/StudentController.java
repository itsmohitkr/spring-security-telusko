package online.devplanet.spring_security_demo.Controller;


import online.devplanet.spring_security_demo.model.Student;
import online.devplanet.spring_security_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentSevice;

    // get student
    @GetMapping("/student")
    public List<Student> getStudent(Authentication authentication) {
        return studentSevice.getAllStudent(authentication);
    }

    // create student
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student, Authentication authentication) {
        return studentSevice.add(student,authentication);
    }

}
