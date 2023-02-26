package com.hui.dict.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName: com.hui.dict.utils
 * @ClassName: RegexpUtils
 * @Author: winwa
 * @Date: 2023/2/26 7:31
 * @Description:
 **/
public class RegexpUtils {

    public static String replaceAll(String s, String pattern) {
        Pattern ptn = Pattern.compile(pattern);
        Matcher matcher = ptn.matcher(s);
        return matcher.replaceAll("");
    }
}
