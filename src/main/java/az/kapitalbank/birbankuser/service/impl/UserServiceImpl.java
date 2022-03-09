package az.kapitalbank.birbankuser.service.impl;

import az.kapitalbank.birbankuser.domain.User;
import az.kapitalbank.birbankuser.exception.UserNotFoundExeption;
import az.kapitalbank.birbankuser.repository.UserRepo;
import az.kapitalbank.birbankuser.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
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
        Optional<User> optioalUser = repository.findById(id);
        if (!optioalUser.isPresent()) {
            throw new UserNotFoundExeption("User with id " + id + " not found");
        }
        return optioalUser.get();
    }

    @Override
    public User createUser(User user) {
        repository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundExeption("User with id " + id + " not found");
        }
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
}
