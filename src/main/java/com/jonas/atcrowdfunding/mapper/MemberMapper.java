package com.jonas.atcrowdfunding.mapper;

import com.jonas.atcrowdfunding.bean.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {
    Member login(Map<String,Object> map);

    Member findByLoginAcct(String loginacct);
}
