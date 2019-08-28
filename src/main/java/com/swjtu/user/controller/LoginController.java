package com.swjtu.user.controller;

import com.swjtu.user.constant.CookieConstant;
import com.swjtu.user.constant.RedisConstant;
import com.swjtu.user.dataobject.UserInfo;
import com.swjtu.user.enums.ResultEnum;
import com.swjtu.user.enums.RoleEnum;
import com.swjtu.user.service.impl.UserServiceImpl;
import com.swjtu.user.utils.CookieUtil;
import com.swjtu.user.utils.ResultVOUtil;
import com.swjtu.user.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 李天峒
 * @date 2019/8/16 0:33
 */
@Api(value = "user服务接口")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家登录
     * @param openId
     * @param response
     * @return
     */
    @ApiOperation(value = "买家登录")
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openId") String openId,
                          HttpServletResponse response) {
        //1. openid和数据库里面的数据进行匹配
        UserInfo userInfo = userService.findByOpenId(openId);
        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL.getCode(), ResultEnum.LOGIN_FAIL.getMsg());
        }
        //2. 判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL.getCode(), ResultEnum.ROLE_ERROR.getMsg());
        }
        //3. cookie里设置openid = openid
        CookieUtil.set(response, CookieConstant.OPENID, openId, CookieConstant.EXPIRE);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     * @param openId
     * @param response
     * @return
     */
    @ApiOperation(value = "卖家登录")
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openId") String openId,
                           HttpServletRequest request,
                           HttpServletResponse response) {

        //0. 判断用户是否已经登录(一句当前的cookie是否为空以及目前登录的openid和缓存里面的token_UUID保存的值是否一致)
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie !=null && redisTemplate.opsForValue().
                get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())).equals(openId)){
            return ResultVOUtil.success();
        }
        //1. openid和数据库里面的数据进行匹配
        UserInfo userInfo = userService.findByOpenId(openId);
        if (null == userInfo) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL.getCode(), ResultEnum.LOGIN_FAIL.getMsg());
        }
        //2. 判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL.getCode(), ResultEnum.ROLE_ERROR.getMsg());
        }
        //3. redis设置key = UUID，value = openid
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openId,
                CookieConstant.EXPIRE,
                TimeUnit.SECONDS);
        //4. cookie里设置token = UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPIRE);
        return ResultVOUtil.success();

    }
}
