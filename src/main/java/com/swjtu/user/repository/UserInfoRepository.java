package com.swjtu.user.repository;

import com.swjtu.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * @author 李天峒
 * @date 2019/8/16 0:25
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 根据openid 查询信息
     * @param openId
     * @return
     */
    UserInfo findByOpenId(String openId);

    /**
     * 通过接角色类型来查询人员信息
     * @param role
     * @return
     */
    List<UserInfo> findByRole(Integer role);
}
