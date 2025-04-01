package online.devplanet.spring_security_demo.Repo;

import online.devplanet.spring_security_demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books,Integer> {


}
