package online.devplanet.spring_security_demo.Repo;

import online.devplanet.spring_security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
