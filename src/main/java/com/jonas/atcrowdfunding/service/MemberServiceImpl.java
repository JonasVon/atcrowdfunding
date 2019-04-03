package com.jonas.atcrowdfunding.service;

import com.jonas.atcrowdfunding.bean.Member;
import com.jonas.atcrowdfunding.exception.CommonException;
import com.jonas.atcrowdfunding.mapper.MemberMapper;
import com.jonas.atcrowdfunding.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Member login(Map<String, Object> map) {
        Member member = memberMapper.login(map);
        if(member == null){//根据用户名和密码查询不到用户
            String loginacct = (String) map.get("loginacct");
            if(memberMapper.findByLoginAcct(loginacct) != null){
                //用户名存在,密码错误
                throw new CommonException(Const.PASSWORD_ERROR);
            }else{
                //用户名不存在
                throw new CommonException(Const.USER_NOT_IN);
            }
        }
        return member;
    }
}
