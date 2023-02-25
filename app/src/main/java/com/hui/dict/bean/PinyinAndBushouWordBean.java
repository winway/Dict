package com.hui.dict.bean;

import java.util.List;

/**
 * @PackageName: com.hui.dict.bean
 * @ClassName: WordBean
 * @Author: winwa
 * @Date: 2023/2/20 7:59
 * @Description:
 **/
public class PinyinAndBushouWordBean {

    /**
     * reason : 返回成功
     * result : {"list":[{"id":"36db6db27f609069","zi":"罓","py":"wang","wubi":"","pinyin":"wǎng","bushou":"冂","bihua":"4"},{"id":"0bb8e0f3c8b5ca3c","zi":"网","py":"wang","wubi":"mqqi","pinyin":"wǎng","bushou":"冂","bihua":"6"},{"id":"5a959df7480ceb2f","zi":"罔","py":"wang","wubi":"muyn","pinyin":"wǎng","bushou":"冂","bihua":"8"},{"id":"8903000bef87e789","zi":"亾","py":"wang","wubi":"","pinyin":"wáng","bushou":"人","bihua":"3"},{"id":"07e987c6ee73f013","zi":"仼","py":"wang","wubi":"wgg","pinyin":"wáng","bushou":"亻","bihua":"6"},{"id":"b448fef8e3badd39","zi":"兦","py":"wang","wubi":"","pinyin":"wáng","bushou":"入","bihua":"3"},{"id":"f90938c2f4bbda18","zi":"亡","py":"wang,wu","wubi":"ynv","pinyin":"wáng,wú","bushou":"亠","bihua":"3"},{"id":"1ca99deb1ca99b79","zi":"莣","py":"wang","wubi":"aynn","pinyin":"wáng","bushou":"艹","bihua":"10"},{"id":"ccef66f5b8f31422","zi":"菵","py":"wang","wubi":"amun","pinyin":"wǎng","bushou":"艹","bihua":"11"},{"id":"5be3d1b528abae06","zi":"彺","py":"wang","wubi":"tgg","pinyin":"wǎng","bushou":"彳","bihua":"7"}],"page":1,"pagesize":10,"totalpage":4,"totalcount":40}
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
         * list : [{"id":"36db6db27f609069","zi":"罓","py":"wang","wubi":"","pinyin":"wǎng","bushou":"冂","bihua":"4"},{"id":"0bb8e0f3c8b5ca3c","zi":"网","py":"wang","wubi":"mqqi","pinyin":"wǎng","bushou":"冂","bihua":"6"},{"id":"5a959df7480ceb2f","zi":"罔","py":"wang","wubi":"muyn","pinyin":"wǎng","bushou":"冂","bihua":"8"},{"id":"8903000bef87e789","zi":"亾","py":"wang","wubi":"","pinyin":"wáng","bushou":"人","bihua":"3"},{"id":"07e987c6ee73f013","zi":"仼","py":"wang","wubi":"wgg","pinyin":"wáng","bushou":"亻","bihua":"6"},{"id":"b448fef8e3badd39","zi":"兦","py":"wang","wubi":"","pinyin":"wáng","bushou":"入","bihua":"3"},{"id":"f90938c2f4bbda18","zi":"亡","py":"wang,wu","wubi":"ynv","pinyin":"wáng,wú","bushou":"亠","bihua":"3"},{"id":"1ca99deb1ca99b79","zi":"莣","py":"wang","wubi":"aynn","pinyin":"wáng","bushou":"艹","bihua":"10"},{"id":"ccef66f5b8f31422","zi":"菵","py":"wang","wubi":"amun","pinyin":"wǎng","bushou":"艹","bihua":"11"},{"id":"5be3d1b528abae06","zi":"彺","py":"wang","wubi":"tgg","pinyin":"wǎng","bushou":"彳","bihua":"7"}]
         * page : 1
         * pagesize : 10
         * totalpage : 4
         * totalcount : 40
         */

        private int page;
        private int pagesize;
        private int totalpage;
        private int totalcount;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getTotalcount() {
            return totalcount;
        }

        public void setTotalcount(int totalcount) {
            this.totalcount = totalcount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 36db6db27f609069
             * zi : 罓
             * py : wang
             * wubi :
             * pinyin : wǎng
             * bushou : 冂
             * bihua : 4
             */

            private String id;
            private String zi;
            private String py;
            private String wubi;
            private String pinyin;
            private String bushou;
            private String bihua;

            public ListBean(String id, String zi, String py, String wubi, String pinyin, String bushou, String bihua) {
                this.id = id;
                this.zi = zi;
                this.py = py;
                this.wubi = wubi;
                this.pinyin = pinyin;
                this.bushou = bushou;
                this.bihua = bihua;
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
        }
    }
}
