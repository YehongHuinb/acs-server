package com.sw.acs.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

/**
 * @author: 周良聪
 * @date: 2020/10/23 08:38
 */
public class JwtUtils {

    /**
     * 生成签名
     * @param userName 用户名
     * @param secret 用户的密码
     * @return token
     */
    public static String sign(String userName, String secret){
        Calendar instance = Calendar.getInstance();
        //设置过期时间
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("userName",userName)
                .withSubject(userName)
                .withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(secret));

    }

    /**
     *
     * @param token token
     * @param userName 用户名
     * @param secret 密钥
     */
    public static boolean verify(String token,String userName, String secret){
        try{
            JWT.require(Algorithm.HMAC256(secret)).withClaim("userName",userName).build().verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * 解析token
     * @param token token
     * @param claim
     * @return 结果
     */
    public static String parseToken(String token,String claim){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(claim).asString();
    }

    /**
     * 判断token是否过期
     * @param token token
     * @return 结果
     */
    public static boolean isExpire(String token){
        DecodedJWT jwt = JWT.decode(token);
        return System.currentTimeMillis() > jwt.getExpiresAt().getTime();
    }
}
