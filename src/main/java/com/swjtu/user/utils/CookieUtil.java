package com.swjtu.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李天峒
 * @date 2019/8/19 0:40
 */
public class CookieUtil {

    /**
     * 设置访问的cookie属性
     * @param response 请求属性
     * @param name 名称
     * @param value 值
     * @param maxAge 过期时间
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge){

        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie get(HttpServletRequest request,
                             String name){
        Cookie[] cookies = request.getCookies();
        if (cookies !=null){
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
