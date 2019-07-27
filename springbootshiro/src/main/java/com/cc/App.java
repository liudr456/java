package com.cc;


import com.cc.dao.UserDOMapper;
import com.cc.model.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication(scanBasePackages = {"com.cc"})
@EnableAutoConfiguration
@MapperScan("com.cc.dao")
public class App {
    @Autowired
    private UserDOMapper userDOMapper;
    private final static Logger logger = LoggerFactory.getLogger(App.class);
    @RequestMapping("/")
    public String home(){
        UserDO userDO;

        userDO=userDOMapper.selectByPrimaryKey(1);
        if(userDO==null)
            return "用户不存在！";
        else{
            return userDO.getUserName();
        }

    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.info("hello slf4j");
        logger.debug("debug");
        logger.warn("warn");
        SpringApplication.run(App.class,args);
    }
}
