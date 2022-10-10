package com.angryzyh.ylb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.angryzyh.ylb.pojo.po.UserPo;
import com.angryzyh.ylb.service.UserService;
import com.angryzyh.ylb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Angryzyh
* @description 针对表【u_user(用户表)】的数据库操作Service实现
* @createDate 2022-10-09 14:24:26
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public Integer getUserCount() {
        return userMapper.selectUserCount();
    }
}




