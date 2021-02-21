package org.example.project.api.users;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public User save(User user) {
        this.users.add(user);
        return user;
    }

    public List<User> getAll() {
        return this.users;
    }

    public User getById(int id) {
        return this.users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }

    public User update(User user) {
        User userFound = getById(user.getId());
        this.users.set(users.indexOf(userFound), user);
        return user;
    }

    public void delete(User user) {
        this.users.remove(user);
    }
}
