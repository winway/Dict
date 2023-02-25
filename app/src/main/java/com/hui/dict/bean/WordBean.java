package com.hui.dict.bean;

import java.util.List;

/**
 * @PackageName: com.hui.dict.bean
 * @ClassName: WordBean
 * @Author: winwa
 * @Date: 2023/2/24 8:47
 * @Description:
 **/
public class WordBean {

    /**
     * reason : 返回成功
     * result : {"id":"36bc3372d9b9fec7","zi":"啊","py":"a","wubi":"kbsk","pinyin":"á,à,ǎ,ā,ɑ","bushou":"口","bihua":"10","jijie":["啊","ā","叹词，表示赞叹或惊异：啊，这花真美呀！啊哈。啊呀。","","啊","á","　ㄚˊ","叹词，表示疑问或反问：啊，你说什么？","","啊","ǎ","　ㄚˇ","叹词，表示疑惑：啊，这是怎么回事？","","啊","à","　ㄚˋ","叹词，表示应诺（音较短）：啊，好吧！","叹词，表示醒悟（音较长）：啊，我这才明白过来！","表示赞叹（音较长）：啊，亲爱的祖国！","","啊","ɑ","　ㄚ","助词，在句末，表示惊叹的语气（常因前面字音不同而发生变音，可用不同的字来表示）：你好啊（哇）！真新鲜啊（哪）！","","笔画数：10；","部首：口；","笔顺编号：2515212512"],"xiangjie":["啊","ā","【叹】","(形声。从口,阿声。本义:叹词)表示惊叹或赞颂〖ah〗。如:啊!多么美丽的夜色;啊!祖国,我为您歌唱","另见á;ǎ;à;a","","啊哈","āhā","〖oh;ah;well〗表示语气的叹词","表示惊喜","啊哈,我看见他了","表示恍然大悟","啊哈,我明白了","表示满意","啊哈,总算干得还不赖","啊呀","āyā","叹词","〖oh〗∶表示惊讶","啊呀,他跑得真快呀","〖why〗∶表示不满,为难","啊呀,怎么弄了满地的水","啊呀,这事不好办哪","啊哟","āyō","〖ayo〗叹词,表示情绪激动或惊讶","啊哟,吓死我了","啊唷","āyō","同\u201c啊哟\u201d","","啊","á","【叹】","表示追问或要求再说一遍〖ah〗。如:啊?你说谁?你想过这些事没有?啊!","另见ā;ǎ;à;a","","啊","ǎ","【叹】","表示惊疑或疑惑〖ah〗。如:啊?这是怎么回事;他说我还小,啊?我不小了吧;啊?可以这样说吗?","另见ā;á;à;a","","啊","à","【叹】","表示应诺等的叹词〖ah〗","表示应诺。如:啊,我就去;啊,好吧","表示醒悟。如:啊,对啦!对啦;啊,原来是他,怪不得看着挺面熟","表示惊异或赞叹。如:啊!黄河,你是我们民族的摇篮","用来表示悲痛、遗憾或忧伤〖woe〗","另见ā;á;ǎ;a","","啊","阿","a","【助】","表示语气〖what〗","用在感叹句末,加强感叹语气。如:他跑得真快啊","用在陈述句或祈使句,表示肯定、辨明、请求、劝止、警告、催促、命令等。如:这话说得对啊!请坐啊,女士们","用在问句末尾〖really?〗","在有疑问指代词的问句或选择问句里,用来和缓语气。如:是谁啊?","在陈述句形式的问句里,提问的目的是要求得到证实。如:你不去啊?","用在打招呼的话里〖hay〗。如:老张啊,你这儿来!","用在重复的动词后面,表示过程长〖onandon〗。如:\u2026找啊找啊,终于找到了金矿","另见ā;á;ǎ;à;","\u201c阿\u201d另见ā;ǎ;à;ē"]}
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
         * id : 36bc3372d9b9fec7
         * zi : 啊
         * py : a
         * wubi : kbsk
         * pinyin : á,à,ǎ,ā,ɑ
         * bushou : 口
         * bihua : 10
         * jijie : ["啊","ā","叹词，表示赞叹或惊异：啊，这花真美呀！啊哈。啊呀。","","啊","á","　ㄚˊ","叹词，表示疑问或反问：啊，你说什么？","","啊","ǎ","　ㄚˇ","叹词，表示疑惑：啊，这是怎么回事？","","啊","à","　ㄚˋ","叹词，表示应诺（音较短）：啊，好吧！","叹词，表示醒悟（音较长）：啊，我这才明白过来！","表示赞叹（音较长）：啊，亲爱的祖国！","","啊","ɑ","　ㄚ","助词，在句末，表示惊叹的语气（常因前面字音不同而发生变音，可用不同的字来表示）：你好啊（哇）！真新鲜啊（哪）！","","笔画数：10；","部首：口；","笔顺编号：2515212512"]
         * xiangjie : ["啊","ā","【叹】","(形声。从口,阿声。本义:叹词)表示惊叹或赞颂〖ah〗。如:啊!多么美丽的夜色;啊!祖国,我为您歌唱","另见á;ǎ;à;a","","啊哈","āhā","〖oh;ah;well〗表示语气的叹词","表示惊喜","啊哈,我看见他了","表示恍然大悟","啊哈,我明白了","表示满意","啊哈,总算干得还不赖","啊呀","āyā","叹词","〖oh〗∶表示惊讶","啊呀,他跑得真快呀","〖why〗∶表示不满,为难","啊呀,怎么弄了满地的水","啊呀,这事不好办哪","啊哟","āyō","〖ayo〗叹词,表示情绪激动或惊讶","啊哟,吓死我了","啊唷","āyō","同\u201c啊哟\u201d","","啊","á","【叹】","表示追问或要求再说一遍〖ah〗。如:啊?你说谁?你想过这些事没有?啊!","另见ā;ǎ;à;a","","啊","ǎ","【叹】","表示惊疑或疑惑〖ah〗。如:啊?这是怎么回事;他说我还小,啊?我不小了吧;啊?可以这样说吗?","另见ā;á;à;a","","啊","à","【叹】","表示应诺等的叹词〖ah〗","表示应诺。如:啊,我就去;啊,好吧","表示醒悟。如:啊,对啦!对啦;啊,原来是他,怪不得看着挺面熟","表示惊异或赞叹。如:啊!黄河,你是我们民族的摇篮","用来表示悲痛、遗憾或忧伤〖woe〗","另见ā;á;ǎ;a","","啊","阿","a","【助】","表示语气〖what〗","用在感叹句末,加强感叹语气。如:他跑得真快啊","用在陈述句或祈使句,表示肯定、辨明、请求、劝止、警告、催促、命令等。如:这话说得对啊!请坐啊,女士们","用在问句末尾〖really?〗","在有疑问指代词的问句或选择问句里,用来和缓语气。如:是谁啊?","在陈述句形式的问句里,提问的目的是要求得到证实。如:你不去啊?","用在打招呼的话里〖hay〗。如:老张啊,你这儿来!","用在重复的动词后面,表示过程长〖onandon〗。如:\u2026找啊找啊,终于找到了金矿","另见ā;á;ǎ;à;","\u201c阿\u201d另见ā;ǎ;à;ē"]
         */

        private String id;
        private String zi;
        private String py;
        private String wubi;
        private String pinyin;
        private String bushou;
        private String bihua;
        private List<String> jijie;
        private List<String> xiangjie;

        public ResultBean(String id, String zi, String py, String wubi, String pinyin, String bushou, String bihua, List<String> jijie, List<String> xiangjie) {
            this.id = id;
            this.zi = zi;
            this.py = py;
            this.wubi = wubi;
            this.pinyin = pinyin;
            this.bushou = bushou;
            this.bihua = bihua;
            this.jijie = jijie;
            this.xiangjie = xiangjie;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getZi() {
            return zi;
        }

        public void setZi(String zi) {
            this.zi = zi;
        }

        public String getPy() {
            return py;
        }

        public void setPy(String py) {
            this.py = py;
        }

        public String getWubi() {
            return wubi;
        }

        public void setWubi(String wubi) {
            this.wubi = wubi;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getBihua() {
            return bihua;
        }

        public void setBihua(String bihua) {
            this.bihua = bihua;
        }

        public List<String> getJijie() {
            return jijie;
        }

        public void setJijie(List<String> jijie) {
            this.jijie = jijie;
        }

        public List<String> getXiangjie() {
            return xiangjie;
        }

        public void setXiangjie(List<String> xiangjie) {
            this.xiangjie = xiangjie;
        }
    }
}
