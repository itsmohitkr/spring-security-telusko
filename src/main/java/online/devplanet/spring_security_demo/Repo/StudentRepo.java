package online.devplanet.spring_security_demo.Repo;

import online.devplanet.spring_security_demo.model.Student;
import online.devplanet.spring_security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findAllByUser(User user);
}
