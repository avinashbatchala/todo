package com.nashb.todo.users;

import java.util.List;

public interface UserService {
    User registerUser(User user) throws Exception;
    List<User> getAllUsers();
}
