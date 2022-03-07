package az.kapitalbank.birbankuser.service.impl;

import az.kapitalbank.birbankuser.domain.User;
import az.kapitalbank.birbankuser.repository.UserRepo;
import az.kapitalbank.birbankuser.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User findUser(Long id) {
        return repository.getById(id);
    }

    @Override
    public User createUser(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User changeUser(Long id, User user) {
        User dbUser = repository.getById(id);
        dbUser.setId(user.getId());
        dbUser.setName(user.getName());
        dbUser.setSurname(user.getSurname());
        dbUser.setBirthDay(user.getBirthDay());
        dbUser.setBalance(user.getBalance());
        return repository.save(dbUser);
    }

    @Override
    public User getUserByName(String name) {
        return repository.findByName(name);
    }
}
