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
    private static final String SIGN = "a1b2c3d4e5f6g7h8i9j10k11l12m13n14o15p16q17r18s19t20u21v22w23x24y25z26!@#$%^&*()_+";

    public static String sign(String userName){
        Calendar instance = Calendar.getInstance();
        //设置过期时间
        instance.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();

        builder.withClaim("userName",userName)
                .withSubject(userName)
                .withExpiresAt(instance.getTime());

        return builder.sign(Algorithm.HMAC256(SIGN));

    }

    public static void verify(String token,String userName){
        JWT.require(Algorithm.HMAC256(SIGN)).withClaim("userName",userName).build().verify(token);
    }

    public static String parseToken(String token,String claim){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(claim).asString();
    }
}
