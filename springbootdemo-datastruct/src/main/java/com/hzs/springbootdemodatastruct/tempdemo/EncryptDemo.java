package com.hzs.springbootdemodatastruct.tempdemo;

import java.util.Arrays;

/**
 * TODO
 *
 * @author hezhensheng3
 * @date 2020-01-03 13:30
 **/
public class EncryptDemo {
    public static void main(String[] args) {
        String text = "a1234";
        System.out.println(encryptText(text));
    }

    public static String encryptText(String text) {
        char[] cs = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            c += '9';
            sb.append(c);
        }
        return sb.toString();
    }

}
