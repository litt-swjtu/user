package com.swjtu.user.enums;

import lombok.Getter;

/**
 * @author 李天峒
 * @date 2019/8/19 0:34
 */
@Getter
public enum ResultEnum {
    /** 结果状态码*/
    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"角色错误");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
