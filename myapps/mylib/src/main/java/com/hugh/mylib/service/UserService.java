package com.hugh.mylib.service;

import com.hugh.mylib.dao.UserDAO;
import com.hugh.mylib.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDao;

    public boolean isExist(String username){
        User user=userDao.findByUsername(username);
        return null!=user;
    }

    public User getByname(String username){
        return  userDao.findByUsername(username);
    }

    public User get(String username,String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    public void add(User user){
        userDao.save(user);
    }
}
