package com.nashb.todo.users;

import javax.naming.AuthenticationException;
import java.util.List;

public interface UserService {
    User registerUser(User user) throws Exception;
    List<User> getAllUsers();
    User findByEmailAndPassword(String email, String Password) throws Exception;
    User findByEmail(String email);
}
