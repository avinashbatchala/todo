package com.nashb.todo.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    int countAllByEmail(String email);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);


}
