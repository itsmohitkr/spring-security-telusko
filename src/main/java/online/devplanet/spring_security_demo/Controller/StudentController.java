package online.devplanet.spring_security_demo.Controller;


import online.devplanet.spring_security_demo.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // create sample list of students
    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "John", "Java"),
            new Student(2, "Jane", "Python"),
            new Student(3, "Doe", "C++")
    ));

    // get student
    @GetMapping("/student")
    public List<Student> getStudent() {
        return students;
    }

    // create student
    @PostMapping("/student")
    public boolean createStudent(@RequestBody Student student) {
        return students.add(student);
    }

}
