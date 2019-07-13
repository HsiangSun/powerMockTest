package cn.hsiangsun.service;

import cn.hsiangsun.bean.User;
import cn.hsiangsun.dao.UserDao;


public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user){
        userDao.add(user);
    }

    public int getUserAge(){
        return userDao.getAge();
    }
}
