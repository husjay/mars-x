package com.mars.x.utils;

import java.text.MessageFormat;

/**
 * Created by sj.hu on 2019/4/1.
 */
public class StringUtils {

    /**
     * 字符串消减操作，从尾部开始消减
     * @param str
     * @param suffix
     * @return
     */
    public static String trimEnd(String str, String suffix) {
        if(null == str || "".equals(str)) {
            return "";
        }
        if(null == suffix || "".equals(suffix)) {
            return str;
        }
        str = str.trim();
        suffix = suffix.trim();
        while(str.endsWith(suffix)) {
            str = str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    /**
     * use java.text.MessageFormat has some problem, this method is aim to solve them:
     * 1、单引号(')是方法 format 的标识符，所以字符串中包含单引号时需要用单引号标出来。
     * 2、两个连续的左大括号也是标识符，因此也要用单引号标出来。
     * @param pattern
     * @param arguments
     * @return
     */
    public static String format(String pattern, Object ... arguments) {
        pattern = pattern.replace("'", "''");
        pattern = pattern.replace("{{", "'{{'");

        for(int i=0; i<arguments.length; i++)
            arguments[i] = arguments[i].toString();

        return MessageFormat.format(pattern, arguments);
    }
}
