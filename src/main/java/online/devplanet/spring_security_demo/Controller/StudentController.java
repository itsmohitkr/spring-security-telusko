package online.devplanet.spring_security_demo.Controller;


import online.devplanet.spring_security_demo.model.Student;
import online.devplanet.spring_security_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentSevice;

    @GetMapping("/student")
    public List<Student> getStudent() {
        return studentSevice.getAllStudent();
    }

    // create student
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentSevice.add(student);
    }
}
