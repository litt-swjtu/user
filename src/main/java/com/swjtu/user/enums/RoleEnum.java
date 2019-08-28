package com.swjtu.user.enums;

import lombok.Getter;

/**
 * @author 李天峒
 * @date 2019/8/18 19:24
 */
@Getter
public enum RoleEnum {
    /**
     * 卖家角色
     */
    BUYER(1,"买家"),
    SELLER(2,"卖家");

    /**
     * 代码
     */
    private Integer code;

    /**
     * 含义
     */
    private String msg;

    RoleEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
