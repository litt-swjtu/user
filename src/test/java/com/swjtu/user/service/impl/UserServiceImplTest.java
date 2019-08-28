package com.swjtu.user.service.impl;

import com.swjtu.user.dataobject.UserInfo;
import com.swjtu.user.enums.RoleEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/8/18 22:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {


    @Autowired
    private UserServiceImpl userService;
    @Test
    public void findByOpenId() {
    }

    @Test
    public void userInfoList() {
        List<UserInfo> userInfoList = userService.userInfoList(RoleEnum.SELLER.getCode());
        Assert.assertNotNull(userInfoList);
        log.info("【userInfoList】={}",userInfoList);
    }
}