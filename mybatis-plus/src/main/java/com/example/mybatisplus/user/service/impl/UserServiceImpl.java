package com.example.mybatisplus.user.service.impl;

import com.example.mybatisplus.user.entity.User;
import com.example.mybatisplus.user.mapper.UserMapper;
import com.example.mybatisplus.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author why
 * @since 2018-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
