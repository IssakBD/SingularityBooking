package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    @Modifying
    @Query(value = "INSERT INTO users(username, email, first_name, last_name, password, created, updated, status) VALUES (:user.getUsername(), :user.getEmail(), :user.getFirstName, :user.getLastName(), :user.getPassword(), :user.getCreated(), :user.getUpdated(), :user.getStatus())" +"; " +
            "INSERT INTO user_roles(user_id, role_id) VALUES (:user.getId(), 1)", nativeQuery = true)
    void saveUserAndSetRole(User user);
}
