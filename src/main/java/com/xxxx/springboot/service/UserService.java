package com.xxxx.springboot.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.springboot.dao.UserDao;
import com.xxxx.springboot.query.UserQuery;
import com.xxxx.springboot.utils.AssertUtil;
import com.xxxx.springboot.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
   @Autowired
    private UserDao userDao;
/*
    @Cacheable(value = "users",key="#userName")
    public User queryUserByUserName(String userName){
        return userDao.queryUserByUserName(userName);
    }




    @Cacheable(value = "users",key="#userId")
    public User queryUserByUserId(Integer userId){
        AssertUtil.isTrue(true,"异常测试...");
        return userDao.queryById(userId);
    }*/



    @Transactional(propagation = Propagation.REQUIRED)  //让方法变成Spring中的事务
    public void saveUser(User user){
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空!");
        //StringUtils 用来判断字符串是否为空
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不能为空!");
        AssertUtil.isTrue(null!=userDao.queryUserByUserName(user.getUserName()),"该用户已存在!");
        AssertUtil.isTrue(userDao.save(user)<1,"用户记录添加失败!");
    }

    /*@Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user){
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserName()),"用户名不能为空!");
        AssertUtil.isTrue(StringUtils.isBlank(user.getUserPwd()),"用户密码不能为空!");
        AssertUtil.isTrue(null==userDao.queryById(user.getId()),"该用户不存在!");
        // 用户名唯一校验
        User  temp =userDao.queryUserByUserName(user.getUserName());
        AssertUtil.isTrue(null !=temp && !(temp.getId().equals(user.getId())),"用户已存在!");
        AssertUtil.isTrue(userDao.update(user)<1,"用户更新失败!");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer userId){
        AssertUtil.isTrue(null==userId || null==userDao.queryById(userId),"该用户不存在!");
        AssertUtil.isTrue(userDao.delete(userId)<1,"用户删除失败!");
        int a=1/0;
    }

    @Cacheable(value = "users",key="#userQuery.userName+'-'+#userQuery.pageNum+'-'+#userQuery.pageSize")
    public PageInfo<User> queryUsersByParams(UserQuery userQuery){
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        List<User> users=userDao.selectByParams(userQuery);
        return new PageInfo<User>(users);
    }
*/



}
