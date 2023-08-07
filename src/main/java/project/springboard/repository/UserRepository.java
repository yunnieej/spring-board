package project.springboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.springboard.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserId(String userId);

    Optional<User> findByUserId(String userId);
}
