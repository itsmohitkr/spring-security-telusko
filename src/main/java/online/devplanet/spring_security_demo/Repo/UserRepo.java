package online.devplanet.spring_security_demo.Repo;

import online.devplanet.spring_security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);


    int findUserIdByUsername(String username);


    User findByUserId(UUID uuid);
}
