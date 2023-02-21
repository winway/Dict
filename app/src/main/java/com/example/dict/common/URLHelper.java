package com.example.dict.common;

/**
 * @PackageName: com.example.dict.common
 * @ClassName: URLHelper
 * @Author: winwa
 * @Date: 2023/2/17 8:39
 * @Description:
 **/
public class URLHelper {

    private static final String DICT_KEY = "b7907d6e1c633211e8eb2d05d63ed35a";

    private static final String CHENGYU_KEY = "eeb8e6ad690a1abd302bd60e67ff6b4b";

    public static String getPinyinQueryUrl(String word, int page, int pageSize) {
        return "http://v.juhe.cn/xhzd/querypy?word=" + word + "&dtype=json&page=" + page + "&pagesize=" + pageSize + "&isjijie=&isxiangjie=&key=" + DICT_KEY;
    }

    public static String getBushouQueryUrl(String word, int page, int pageSize) {
        return "http://v.juhe.cn/xhzd/querybs?word=" + word + "&dtype=json&page=" + page + "&pagesize=" + pageSize + "&isjijie=&isxiangjie=&key=" + DICT_KEY;
    }

    public static String getWordQueryUrl(String word) {
        return "http://v.juhe.cn/xhzd/query?word=" + word + "&dtype=json&key=" + DICT_KEY;
    }

    public static String getChengyuQueryUrl(String word) {
        return "http://apis.juhe.cn/idioms/query?wd=" + word + "&key=" + CHENGYU_KEY;
    }
}
