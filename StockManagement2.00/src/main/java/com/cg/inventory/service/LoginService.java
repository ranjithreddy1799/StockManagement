package com.cg.inventory.service;


import com.cg.inventory.exceptions.LoginException;
import com.cg.inventory.entity.User;

public interface LoginService {
    public User doLogin(String userId, String password)throws LoginException;
    public String encryptUser(User user);
    
}
