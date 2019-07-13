package cn.hsiangsun.test;

import cn.hsiangsun.bean.User;
import cn.hsiangsun.dao.UserDao;
import cn.hsiangsun.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

public class PowerMockTest {

    @Test
    /*
     * 测试有返回值的情况
     * */
    public void testGetAge(){

        //1.powerMock 模拟UserDaoImpl对象
        UserDao userDao = PowerMockito.mock(UserDao.class);
        //2.录制行为（方法调用返回什么内容）
        PowerMockito.when(userDao.getAge() ).thenReturn(18);

        UserService userService =new UserService(userDao);
        //3.断言
        Assert.assertEquals( 18 , userService.getUserAge() );

    }

    @Test
    /*
     * 测试无返回值的情况
     * */
    public void testAddUser(){
        //1.准备对象
        User user =new User();
        user.setName("jimmy");
        //2.模拟对象
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.doNothing().when(userDao).add(user);//无返回值的行为录制

        UserService userService =new UserService(userDao);

        userService.addUser(user);//手动调用方法
        //userService.addUser(user);//手动调用方法

        Mockito.verify(userDao).add(user); //验证手动调用的方法是否执行了一次
        //Mockito.verify(userDao,Mockito.times(2)).add(user);//验证手动调用的方法是否执行了两次
    }

}
