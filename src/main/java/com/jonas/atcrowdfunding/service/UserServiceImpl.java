package com.jonas.atcrowdfunding.service;

import com.jonas.atcrowdfunding.bean.User;
import com.jonas.atcrowdfunding.exception.CommonException;
import com.jonas.atcrowdfunding.mapper.UserMapper;
import com.jonas.atcrowdfunding.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Map<String, Object> map) throws RuntimeException {
        User user = userMapper.login(map);
        if(user == null){
            String loginacct = (String) map.get("loginacct");
            if(userMapper.findByLoginAcct(loginacct) != null){
                //用户名正确，密码错误
                throw new CommonException(Const.PASSWORD_ERROR);
            }else{
                //用户不存在
                throw new CommonException(Const.USER_NOT_IN);
            }
        }
        return user;
    }
}
