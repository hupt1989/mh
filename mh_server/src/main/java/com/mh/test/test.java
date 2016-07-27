package com.mh.test;

/**
 * Created by lenovo on 2016/7/25.
 */

import com.mh.entity.UserEntity;
import com.mh.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 创建时间：2015-2-6 下午3:31:07
 *
 * @author andy
 * @version 2.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mvc.xml",
        "classpath:spring-hibernate-druid-jpa.xml"})
public class test{

    private static final Logger LOGGER = Logger.getLogger(UserService.class);

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        UserEntity entity = new UserEntity();
        entity.setTelphome("13426432529");
        entity.setCreateTime(new Date(System.currentTimeMillis()));
        entity.setAge(28);
        entity.setLevel(2);
        entity.setSex(1);
        userService.save(entity);
    }

}
