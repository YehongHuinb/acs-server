package com.sw.acs.utils;

import java.util.Random;

/**
 * @author: 周良聪
 * @date: 2020/10/24 22:27
 */
public class SaltUtils {
    public static String getSalt(int n){
        char[] chars = "a1b2c3d4e5f6g7h8i9j10k11l12m13n14o15p16q17r18s19t20u21v22w23x24y25z26!@#$%^&*()_+.".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
