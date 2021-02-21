package org.example.project.api.users;

public class UserResponse {
    public int id;
    public String name;
    public String email;

    public UserResponse(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
