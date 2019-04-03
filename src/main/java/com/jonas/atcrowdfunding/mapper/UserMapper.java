package com.jonas.atcrowdfunding.mapper;

import com.jonas.atcrowdfunding.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


@Mapper
public interface UserMapper {
    User login(Map<String,Object> map);

    User findByLoginAcct(String loginacct);
}
