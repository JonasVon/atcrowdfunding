package com.jonas.atcrowdfunding.service;

import com.jonas.atcrowdfunding.bean.User;

import java.util.Map;

public interface UserService {
    User login(Map<String,Object> map);
}
