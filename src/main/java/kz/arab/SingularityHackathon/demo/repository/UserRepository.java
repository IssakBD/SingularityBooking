package kz.arab.SingularityHackathon.demo.repository;

import kz.arab.SingularityHackathon.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    @Modifying
    @Query(value = "INSERT INTO user_roles(user_id, role_id) VALUES (:userId, 1)", nativeQuery = true)
    void setRole(Long userId);
}
