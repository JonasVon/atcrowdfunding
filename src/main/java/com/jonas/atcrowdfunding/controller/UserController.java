package com.jonas.atcrowdfunding.controller;

import com.jonas.atcrowdfunding.bean.Member;
import com.jonas.atcrowdfunding.bean.User;
import com.jonas.atcrowdfunding.service.MemberService;
import com.jonas.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户和管理员登录的处理器
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MemberService memberService;

    //注册表单请求
    @PostMapping("/register.do")
    public String register(String loginacct,String userpswd,String email,String usertype){
        //封装数据
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("loginacct",loginacct);
        map.put("userpswd",userpswd);
        map.put("usertype",usertype);
        map.put("email",email);
        map.put("authstatus","0");//新注册用户未实名，实名功能在后面操作界面进行操作

        //userService.register();
        return "";
    }

    //跳转到注册页面
    @GetMapping("/register.html")
    public String register(){
        return "register";
    }


    //处理管理员和用户的登录请求
    @PostMapping("/login.do")
    public String login(String loginacct, String userpswd, String type, HttpSession httpSession){
        //封装用户提交的数据(前端已做非空验证)
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("loginacct",loginacct);
        map.put("userpswd",userpswd);
        map.put("type",type);

        if(type.equals("user")){
            //管理员登录
            User user = userService.login(map);
            httpSession.setAttribute("user",user);
            return "redirect:main.html";
        }else{
            //用户登录
            Member member = memberService.login(map);
            httpSession.setAttribute("member",member);
            return "redirect:index.html";
        }

    }

    @GetMapping("/login.html")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/main.html")
    public String main(){
        return "main";
    }

    @GetMapping("/index.html")
    public String index(){
        return "index";
    }
}
