package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;

public class UserController {
    private final GBRepository<User, Long> repository;

    public UserController(GBRepository<User, Long> repository) {

        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) {
            return repository.findById(userId);
        }

    public List<User> readAllUsers() {

        return repository.findAll();
    }

    public void updateUser(Long userid, User user) {
        user.setId(userid);
        repository.update(userid, user);
    }

    public void deleteUser(Long userid) {
        repository.delete(userid);
    }

    public void finish() {
        repository.finish();
    }
}
