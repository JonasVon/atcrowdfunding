package com.jonas.atcrowdfunding.service;

import com.jonas.atcrowdfunding.bean.Member;

import java.util.Map;

public interface MemberService {

    Member login(Map<String,Object> map);
}
