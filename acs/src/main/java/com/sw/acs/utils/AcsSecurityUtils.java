package com.sw.acs.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Objects;
import java.util.Random;

/**
 * @author 周良聪
 */
public class AcsSecurityUtils {

    public static String getSalt(int n){
        char[] chars = "a1b2c3d4e5f6g7h8i9j10k11l12m13n14o15p16q17r18s19t20u21v22w23x24y25z26!@#$%^&*()_+.".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static String encryptPassword(String password){
        String salt = getSalt(12);
        Md5Hash md5Hash = new Md5Hash(password,salt,2);
        return md5Hash.toString();
    }

    public static String encryptPassword(String password,String salt){
        Md5Hash md5Hash = new Md5Hash(password,salt,2);
        return md5Hash.toString();
    }

    public static boolean matchesPassword(String rawPassword, String encodedPassword, String salt){
        Md5Hash md5Hash = new Md5Hash(rawPassword,salt,2);
        String password = md5Hash.toString();
        return password.equals(encodedPassword);
    }


    public static Integer getUserId(){
        String token = Objects.requireNonNull(ServletUtils.getRequest()).getHeader("Authorization");
        return JwtUtils.getUserId(token);
    }

}
