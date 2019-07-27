package com.cc.controller;

import com.alibaba.fastjson.JSONObject;
import com.cc.model.UserDO;
import com.cc.pojo.Register;
import com.cc.response.CommonReturnType;
import com.cc.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService service;
    @Autowired
    private MenuController menuController;
    private static Logger logger= LoggerFactory.getLogger(LoginController.class);
    @RequestMapping(value = "/logout",method = {RequestMethod.GET})
    public String index(){
        return "/login";
    }
    @RequestMapping(value="/" ,method = {RequestMethod.GET})
    public String postIndex(){
        return "/login";
    }
    @RequestMapping(value="/login" ,method = {RequestMethod.GET})
    public String getLogin(){
        return "/login";
    }
    /**
     * 登录控制
     * @param map 用户名，密码
     * @return MenuDO
     * */
    @ResponseBody
    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public CommonReturnType login(@RequestBody Map map){
        logger.info("进入登录验证");
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(
                map.get("username").toString(),
                map.get("password").toString());
        CommonReturnType commonReturnType=new CommonReturnType();
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            logger.info("登录成功");

        }catch (Exception e){
            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
            commonReturnType.setData("账号或密码错误");
            return commonReturnType;
        }
        commonReturnType=commonReturnType.create(menuController.RecursiveNode(1));
        return commonReturnType;
    }
//    @ResponseBody
//    @RequestMapping(value="/register",method = {RequestMethod.POST})
//    public CommonReturnType register(@RequestBody UserDO userDO){
//        CommonReturnType commonReturnType=new CommonReturnType();
//        int result=service.InsertUser(userDO);
//        if(result == 0){
//            commonReturnType.setStatus(commonReturnType.STATUS_FAIL);
//            commonReturnType.setData("注册失败");
//        }else {
//            commonReturnType=commonReturnType.create("登录成功");
//        }
//        return commonReturnType;
//    }
    /**
     * 修改密码
     * */
    @ResponseBody
    @RequestMapping(value="/upPassword",method = {RequestMethod.POST})
    public CommonReturnType updatepassword(@RequestBody UserDO userDO){
        userDO.setUserId(service.GetUserName(userDO.getUserTelphone()).getUserId());
        service.UpdateUser(userDO);
        CommonReturnType commonReturnType=new CommonReturnType();
        commonReturnType=commonReturnType.create("修改密码成功");
        return commonReturnType;
    }

}
