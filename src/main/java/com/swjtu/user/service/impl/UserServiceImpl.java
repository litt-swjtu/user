package com.swjtu.user.service.impl;

import com.swjtu.user.dataobject.UserInfo;
import com.swjtu.user.repository.UserInfoRepository;
import com.swjtu.user.service.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/8/16 0:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    /**
     * 通过openid来查询用户信息
     *
     * @param openId
     * @return
     */
    @Override
    public UserInfo findByOpenId(String openId) {
        UserInfo userInfo = userInfoRepository.findByOpenId(openId);
        return userInfo;
    }

    @Override
    public List<UserInfo> userInfoList(Integer role) {
        List<UserInfo> userInfoList = userInfoRepository.findByRole(role);
        return userInfoList;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<UserInfo> userInfoList() {
        return null;
    }
}
