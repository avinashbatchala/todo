package com.nashb.todo.users;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.naming.AuthenticationException;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndAndPassword(String email, String password) throws AuthenticationException;

    int countAllByEmail(String email);

    User findUserByEmail(String email);

}
