package com.nashb.todo.users;

import com.nashb.todo.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) throws Exception {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (!user.getEmail().isEmpty()) {
            user.setEmail(user.getEmail().toLowerCase(Locale.ROOT));
        }
        if(!pattern.matcher(user.getEmail()).matches()) {
            throw new Exception("Invalid Email");
        }
        if(userRepository.countAllByEmail(user.getEmail()) > 0) {
            throw new Exception("User Email Already Exists");
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
