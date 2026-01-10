package  repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import model.User;

public class UserRepository {
    private final  Map<UUID, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(UUID id) {
        User user = users.get(id);
        if (user == null) {
            throw new NoSuchElementException("No User with Id:"+ id.toString() + "found!");
        }
        return user;
    }

    public List<User> list() {
        return new ArrayList<>(users.values());
    }
}