package com.joy.rsp.repo.interfaces;


import org.springframework.stereotype.Repository;

@Repository
public interface IUser {
    boolean authenticate(String username, String password);
}

