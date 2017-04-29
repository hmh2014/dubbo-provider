package com.hmh.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by hao on 2017/4/18.
 */
public class Encoding {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("gbk"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
