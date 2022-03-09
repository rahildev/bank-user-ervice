package az.kapitalbank.birbankuser.service;

import az.kapitalbank.birbankuser.domain.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User findUser(Long id);

    User createUser(User user);

    void deleteUser(Long id);

    User changeUser(Long id, User user);
}