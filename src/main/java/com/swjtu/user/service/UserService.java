package com.swjtu.user.service;

import com.swjtu.user.dataobject.UserInfo;

import java.util.List;

/**
 * @author 李天峒
 * @date 2019/8/16 0:27
 */
public interface UserService {

    /**
     * 通过openid来查询用户信息
     * @param openId
     * @return UserInfo
     */
    UserInfo findByOpenId(String openId);

    /**
     * 通过角色类别查询用户信息
     * @param role
     * @return UserInfoList
     */
    List<UserInfo> userInfoList(Integer role);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> userInfoList();
}