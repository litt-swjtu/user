package com.swjtu.user.repository;

import com.swjtu.user.dataobject.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 李天峒
 * @date 2019/8/16 0:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository infoRepository;

    @Test
    public void findUser() {
        UserInfo userInfo = infoRepository.findByOpenId("ltt");
        log.info("【UserInfo】={}", userInfo);
    }

    @Test
    public void save() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1003");
        userInfo.setUsername("王先斌");
        userInfo.setPassword("12345");
        userInfo.setRole(1);
        infoRepository.save(userInfo);
    }

}