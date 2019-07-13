package cn.hsiangsun.dao.impl;

import cn.hsiangsun.bean.User;
import cn.hsiangsun.dao.UserDao;

public class UserDaoImpl implements UserDao {

    public void add(User user) {
        System.out.printf(" add user: %s  success!" , user.getName());//will never executive
    }

    public int getAge() {
        return 20;
    }


}
