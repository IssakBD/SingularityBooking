package kz.arab.SingularityHackathon.demo.service;

import kz.arab.SingularityHackathon.demo.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    void save(User user);

    void setRole(Long userId);
}
