package com.hui.dict.bean;

import java.util.List;

/**
 * @PackageName: com.hui.dict.bean
 * @ClassName: ChengyuBean
 * @Author: winwa
 * @Date: 2023/2/27 20:12
 * @Description:
 **/
public class ChengyuBean {

    /**
     * reason : success
     * result : {"name":"一心一意","pinyin":"yī xīn yī yì","jbsy":["心思、意念专一。"],"xxsy":["【解释】：只有一个心眼儿，没有别的考虑。","【出自】：《三国志·魏志·杜恕传》：\u201c免为庶人，徙章武郡，是岁嘉平元年。\u201d裴松之注引《杜氏新书》：\u201c故推一心，任一意，直而行之耳。\u201d","【示例】：所以彭官保便～的料理防守事宜，庄制军便～料理军需器械。 <br>◎清·张春帆《宦海》第四回","【语法】：联合式；作定语、状语；含褒义"],"chuchu":"《三国志·魏志·杜恕传》:\u201c免为庶人，徙章武郡，是岁嘉平元年。\u201d裴松之注引《杜氏新书》:\u201c故推一心，任一意，直而行之耳。\u201d","liju":"","jyc":["一心一计","一心一路","聚精会神","屏气凝神","推心致腹","全心全意","全神关注","真心实意","全神贯注","一心无二","心无旁骛","专心一志","专心致志"],"fyc":["一心二意","筑室道谋","心不在焉","二三其德","三心二意","见异思迁","三心两意","心猿意马","东张西望"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * name : 一心一意
         * pinyin : yī xīn yī yì
         * jbsy : ["心思、意念专一。"]
         * xxsy : ["【解释】：只有一个心眼儿，没有别的考虑。","【出自】：《三国志·魏志·杜恕传》：\u201c免为庶人，徙章武郡，是岁嘉平元年。\u201d裴松之注引《杜氏新书》：\u201c故推一心，任一意，直而行之耳。\u201d","【示例】：所以彭官保便～的料理防守事宜，庄制军便～料理军需器械。 <br>◎清·张春帆《宦海》第四回","【语法】：联合式；作定语、状语；含褒义"]
         * chuchu : 《三国志·魏志·杜恕传》:“免为庶人，徙章武郡，是岁嘉平元年。”裴松之注引《杜氏新书》:“故推一心，任一意，直而行之耳。”
         * liju :
         * jyc : ["一心一计","一心一路","聚精会神","屏气凝神","推心致腹","全心全意","全神关注","真心实意","全神贯注","一心无二","心无旁骛","专心一志","专心致志"]
         * fyc : ["一心二意","筑室道谋","心不在焉","二三其德","三心二意","见异思迁","三心两意","心猿意马","东张西望"]
         */

        private String name;
        private String pinyin;
        private String chuchu;
        private String liju;
        private List<String> jbsy;
        private List<String> xxsy;
        private List<String> jyc;
        private List<String> fyc;

        public ResultBean(String name, String pinyin, String chuchu, List<String> xxsy, List<String> jyc, List<String> fyc) {
            this.name = name;
            this.pinyin = pinyin;
            this.chuchu = chuchu;
            this.xxsy = xxsy;
            this.jyc = jyc;
            this.fyc = fyc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChuchu() {
            return chuchu;
        }

        public void setChuchu(String chuchu) {
            this.chuchu = chuchu;
        }

        public String getLiju() {
            return liju;
        }

        public void setLiju(String liju) {
            this.liju = liju;
        }

        public List<String> getJbsy() {
            return jbsy;
        }

        public void setJbsy(List<String> jbsy) {
            this.jbsy = jbsy;
        }

        public List<String> getXxsy() {
            return xxsy;
        }

        public void setXxsy(List<String> xxsy) {
            this.xxsy = xxsy;
        }

        public List<String> getJyc() {
            return jyc;
        }

        public void setJyc(List<String> jyc) {
            this.jyc = jyc;
        }

        public List<String> getFyc() {
            return fyc;
        }

        public void setFyc(List<String> fyc) {
            this.fyc = fyc;
        }
    }
}
