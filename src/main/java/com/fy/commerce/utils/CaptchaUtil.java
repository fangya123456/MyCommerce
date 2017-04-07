package com.fy.commerce.utils;

import java.awt.*;
import java.util.Random;

/**
 * Created by fangya on 2017/4/6.
 */
public class CaptchaUtil {

    private static char[] codeChars = new char[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //所有候选组成验证码的字符，当然也可以用中文的

    public static final String SESSION_CODE_NAME="code";

    public static  final int codeLength = 6;  //验证码的长度

    public static String createCode() {
        Random random = new Random();
        String code = "";
         for (int i = 0; i < codeLength; i++) {
             int charNum = random.nextInt(62);
            code += codeChars[charNum];
        }
        if(code.length() != codeLength){
            createCode();
        }
        return code;
    }

    /*
     * 给定范围获得随机颜色
     */
    public static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
