package com.hui.dict.bean;

import java.util.List;

/**
 * @PackageName: com.hui.dict.bean
 * @ClassName: OrcResultBean
 * @Author: winwa
 * @Date: 2023/2/25 10:27
 * @Description:
 **/
public class OcrResultBean {

    /**
     * direction : 0
     * words_result : [{"words":"IntstackIrace("},{"words":"t(title:\"AK,SK方式获取token失败\"，"}]
     * words_result_num : 2
     * log_id : 1629306681281978468
     */

    private int direction;
    private int words_result_num;
    private long log_id;
    private List<WordsResultBean> words_result;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words : IntstackIrace(
         */

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
