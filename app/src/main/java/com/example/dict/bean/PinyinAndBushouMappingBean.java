package com.example.dict.bean;

import java.util.List;

/**
 * @PackageName: com.example.dict.bean
 * @ClassName: PinyinAndBushouMappingBean
 * @Author: winwa
 * @Date: 2023/2/19 8:19
 * @Description:
 **/
public class PinyinAndBushouMappingBean {

    /**
     * reason : success
     * result : [{"id":"1","pinyin_key":"A","pinyin":"a","bihua":"1","bushou":"丨"},{"id":"2","pinyin_key":"A","pinyin":"ai"},{"id":"3","pinyin_key":"A","pinyin":"an"},{"id":"4","pinyin_key":"A","pinyin":"ang"},{"id":"5","pinyin_key":"A","pinyin":"ao"},{"id":"6","pinyin_key":"B","pinyin":"ba"},{"id":"7","pinyin_key":"B","pinyin":"bai"},{"id":"8","pinyin_key":"B","pinyin":"ban"},{"id":"9","pinyin_key":"B","pinyin":"bang"},{"id":"10","pinyin_key":"B","pinyin":"bao"},{"id":"11","pinyin_key":"B","pinyin":"bei"},{"id":"12","pinyin_key":"B","pinyin":"ben"},{"id":"13","pinyin_key":"B","pinyin":"beng"},{"id":"14","pinyin_key":"B","pinyin":"bi"},{"id":"15","pinyin_key":"B","pinyin":"bian"},{"id":"16","pinyin_key":"B","pinyin":"biao"},{"id":"17","pinyin_key":"B","pinyin":"bie"},{"id":"18","pinyin_key":"B","pinyin":"bin"},{"id":"19","pinyin_key":"B","pinyin":"bing"},{"id":"20","pinyin_key":"B","pinyin":"bo"},{"id":"21","pinyin_key":"B","pinyin":"bu"},{"id":"22","pinyin_key":"C","pinyin":"ca"},{"id":"23","pinyin_key":"C","pinyin":"cai"},{"id":"24","pinyin_key":"C","pinyin":"can"},{"id":"25","pinyin_key":"C","pinyin":"cang"},{"id":"26","pinyin_key":"C","pinyin":"cao"},{"id":"27","pinyin_key":"C","pinyin":"ce"},{"id":"28","pinyin_key":"C","pinyin":"cen"},{"id":"29","pinyin_key":"C","pinyin":"ceng"},{"id":"30","pinyin_key":"C","pinyin":"cha"},{"id":"31","pinyin_key":"C","pinyin":"chai"},{"id":"32","pinyin_key":"C","pinyin":"chan"},{"id":"33","pinyin_key":"C","pinyin":"chang"},{"id":"34","pinyin_key":"C","pinyin":"chao"},{"id":"35","pinyin_key":"C","pinyin":"che"},{"id":"36","pinyin_key":"C","pinyin":"chen"},{"id":"37","pinyin_key":"C","pinyin":"cheng"},{"id":"38","pinyin_key":"C","pinyin":"chi"},{"id":"39","pinyin_key":"C","pinyin":"chong"},{"id":"40","pinyin_key":"C","pinyin":"chou"},{"id":"41","pinyin_key":"C","pinyin":"chu"},{"id":"42","pinyin_key":"C","pinyin":"chua"},{"id":"43","pinyin_key":"C","pinyin":"chuai"},{"id":"44","pinyin_key":"C","pinyin":"chuan"},{"id":"45","pinyin_key":"C","pinyin":"chuang"},{"id":"46","pinyin_key":"C","pinyin":"chui"},{"id":"47","pinyin_key":"C","pinyin":"chun"},{"id":"48","pinyin_key":"C","pinyin":"chuo"},{"id":"49","pinyin_key":"C","pinyin":"ci"},{"id":"50","pinyin_key":"C","pinyin":"cong"},{"id":"51","pinyin_key":"C","pinyin":"cou"},{"id":"52","pinyin_key":"C","pinyin":"cu"},{"id":"53","pinyin_key":"C","pinyin":"cuan"},{"id":"54","pinyin_key":"C","pinyin":"cui"},{"id":"55","pinyin_key":"C","pinyin":"cun"},{"id":"56","pinyin_key":"C","pinyin":"cuo"},{"id":"57","pinyin_key":"D","pinyin":"da"},{"id":"58","pinyin_key":"D","pinyin":"dai"},{"id":"59","pinyin_key":"D","pinyin":"dan"},{"id":"60","pinyin_key":"D","pinyin":"dang"},{"id":"61","pinyin_key":"D","pinyin":"dao"},{"id":"62","pinyin_key":"D","pinyin":"de"},{"id":"63","pinyin_key":"D","pinyin":"den"},{"id":"64","pinyin_key":"D","pinyin":"dei"},{"id":"65","pinyin_key":"D","pinyin":"deng"},{"id":"66","pinyin_key":"D","pinyin":"di"},{"id":"67","pinyin_key":"D","pinyin":"dia"},{"id":"68","pinyin_key":"D","pinyin":"dian"},{"id":"69","pinyin_key":"D","pinyin":"diao"},{"id":"70","pinyin_key":"D","pinyin":"die"},{"id":"71","pinyin_key":"D","pinyin":"ding"},{"id":"72","pinyin_key":"D","pinyin":"diu"},{"id":"73","pinyin_key":"D","pinyin":"dong"},{"id":"74","pinyin_key":"D","pinyin":"dou"},{"id":"75","pinyin_key":"D","pinyin":"du"},{"id":"76","pinyin_key":"D","pinyin":"duan"},{"id":"77","pinyin_key":"D","pinyin":"dui"},{"id":"78","pinyin_key":"D","pinyin":"dun"},{"id":"79","pinyin_key":"D","pinyin":"duo"},{"id":"80","pinyin_key":"E","pinyin":"e"},{"id":"81","pinyin_key":"E","pinyin":"ei"},{"id":"82","pinyin_key":"E","pinyin":"en"},{"id":"83","pinyin_key":"E","pinyin":"eng"},{"id":"84","pinyin_key":"E","pinyin":"er"},{"id":"85","pinyin_key":"F","pinyin":"fa"},{"id":"86","pinyin_key":"F","pinyin":"fan"},{"id":"87","pinyin_key":"F","pinyin":"fang"},{"id":"88","pinyin_key":"F","pinyin":"fei"},{"id":"89","pinyin_key":"F","pinyin":"fen"},{"id":"90","pinyin_key":"F","pinyin":"feng"},{"id":"91","pinyin_key":"F","pinyin":"fo"},{"id":"92","pinyin_key":"F","pinyin":"fou"},{"id":"93","pinyin_key":"F","pinyin":"fu"},{"id":"94","pinyin_key":"G","pinyin":"ga"},{"id":"95","pinyin_key":"G","pinyin":"gai"},{"id":"96","pinyin_key":"G","pinyin":"gan"},{"id":"97","pinyin_key":"G","pinyin":"gang"},{"id":"98","pinyin_key":"G","pinyin":"gao"},{"id":"99","pinyin_key":"G","pinyin":"ge"},{"id":"100","pinyin_key":"G","pinyin":"gei"},{"id":"101","pinyin_key":"G","pinyin":"gen"},{"id":"102","pinyin_key":"G","pinyin":"geng"},{"id":"103","pinyin_key":"G","pinyin":"gong"},{"id":"104","pinyin_key":"G","pinyin":"gou"},{"id":"105","pinyin_key":"G","pinyin":"gu"},{"id":"106","pinyin_key":"G","pinyin":"gua"},{"id":"107","pinyin_key":"G","pinyin":"guai"},{"id":"108","pinyin_key":"G","pinyin":"guan"},{"id":"109","pinyin_key":"G","pinyin":"guang"},{"id":"110","pinyin_key":"G","pinyin":"gui"},{"id":"111","pinyin_key":"G","pinyin":"gun"},{"id":"112","pinyin_key":"G","pinyin":"guo"},{"id":"113","pinyin_key":"H","pinyin":"ha"},{"id":"114","pinyin_key":"H","pinyin":"hai"},{"id":"115","pinyin_key":"H","pinyin":"han"},{"id":"116","pinyin_key":"H","pinyin":"hang"},{"id":"117","pinyin_key":"H","pinyin":"hao"},{"id":"118","pinyin_key":"H","pinyin":"he"},{"id":"119","pinyin_key":"H","pinyin":"hei"},{"id":"120","pinyin_key":"H","pinyin":"hen"},{"id":"121","pinyin_key":"H","pinyin":"heng"},{"id":"122","pinyin_key":"H","pinyin":"hong"},{"id":"123","pinyin_key":"H","pinyin":"hou"},{"id":"124","pinyin_key":"H","pinyin":"hu"},{"id":"125","pinyin_key":"H","pinyin":"hua"},{"id":"126","pinyin_key":"H","pinyin":"huai"},{"id":"127","pinyin_key":"H","pinyin":"huan"},{"id":"128","pinyin_key":"H","pinyin":"huang"},{"id":"129","pinyin_key":"H","pinyin":"hui"},{"id":"130","pinyin_key":"H","pinyin":"hun"},{"id":"131","pinyin_key":"H","pinyin":"huo"},{"id":"132","pinyin_key":"J","pinyin":"ji"},{"id":"133","pinyin_key":"J","pinyin":"jia"},{"id":"134","pinyin_key":"J","pinyin":"jian"},{"id":"135","pinyin_key":"J","pinyin":"jiang"},{"id":"136","pinyin_key":"J","pinyin":"jiao"},{"id":"137","pinyin_key":"J","pinyin":"jie"},{"id":"138","pinyin_key":"J","pinyin":"jin"},{"id":"139","pinyin_key":"J","pinyin":"jing"},{"id":"140","pinyin_key":"J","pinyin":"jiong"},{"id":"141","pinyin_key":"J","pinyin":"jiu"},{"id":"142","pinyin_key":"J","pinyin":"ju"},{"id":"143","pinyin_key":"J","pinyin":"juan"},{"id":"144","pinyin_key":"J","pinyin":"jue"},{"id":"145","pinyin_key":"J","pinyin":"jun"},{"id":"146","pinyin_key":"K","pinyin":"ka"},{"id":"147","pinyin_key":"K","pinyin":"kai"},{"id":"148","pinyin_key":"K","pinyin":"kan"},{"id":"149","pinyin_key":"K","pinyin":"kang"},{"id":"150","pinyin_key":"K","pinyin":"kao"},{"id":"151","pinyin_key":"K","pinyin":"ke"},{"id":"152","pinyin_key":"K","pinyin":"ken"},{"id":"153","pinyin_key":"K","pinyin":"keng"},{"id":"154","pinyin_key":"K","pinyin":"kong"},{"id":"155","pinyin_key":"K","pinyin":"kou"},{"id":"156","pinyin_key":"K","pinyin":"ku"},{"id":"157","pinyin_key":"K","pinyin":"kua"},{"id":"158","pinyin_key":"K","pinyin":"kuai"},{"id":"159","pinyin_key":"K","pinyin":"kuan"},{"id":"160","pinyin_key":"K","pinyin":"kuang"},{"id":"161","pinyin_key":"K","pinyin":"kui"},{"id":"162","pinyin_key":"K","pinyin":"kun"},{"id":"163","pinyin_key":"K","pinyin":"kuo"},{"id":"164","pinyin_key":"L","pinyin":"la"},{"id":"165","pinyin_key":"L","pinyin":"lai"},{"id":"166","pinyin_key":"L","pinyin":"lan"},{"id":"167","pinyin_key":"L","pinyin":"lang"},{"id":"168","pinyin_key":"L","pinyin":"lao"},{"id":"169","pinyin_key":"L","pinyin":"le"},{"id":"170","pinyin_key":"L","pinyin":"lei"},{"id":"171","pinyin_key":"L","pinyin":"leng"},{"id":"172","pinyin_key":"L","pinyin":"li"},{"id":"173","pinyin_key":"L","pinyin":"lia"},{"id":"174","pinyin_key":"L","pinyin":"lian"},{"id":"175","pinyin_key":"L","pinyin":"liang"},{"id":"176","pinyin_key":"L","pinyin":"liao"},{"id":"177","pinyin_key":"L","pinyin":"lie"},{"id":"178","pinyin_key":"L","pinyin":"lin"},{"id":"179","pinyin_key":"L","pinyin":"ling"},{"id":"180","pinyin_key":"L","pinyin":"liu"},{"id":"181","pinyin_key":"L","pinyin":"long"},{"id":"182","pinyin_key":"L","pinyin":"lou"},{"id":"183","pinyin_key":"L","pinyin":"lu"},{"id":"184","pinyin_key":"L","pinyin":"lü"},{"id":"185","pinyin_key":"L","pinyin":"luan"},{"id":"186","pinyin_key":"L","pinyin":"lue"},{"id":"187","pinyin_key":"L","pinyin":"lüe"},{"id":"188","pinyin_key":"L","pinyin":"lun"},{"id":"189","pinyin_key":"L","pinyin":"luo"},{"id":"190","pinyin_key":"M","pinyin":"m"},{"id":"191","pinyin_key":"M","pinyin":"ma"},{"id":"192","pinyin_key":"M","pinyin":"mai"},{"id":"193","pinyin_key":"M","pinyin":"man"},{"id":"194","pinyin_key":"M","pinyin":"mang"},{"id":"195","pinyin_key":"M","pinyin":"mao"},{"id":"196","pinyin_key":"M","pinyin":"me"},{"id":"197","pinyin_key":"M","pinyin":"mei"},{"id":"198","pinyin_key":"M","pinyin":"men"},{"id":"199","pinyin_key":"M","pinyin":"meng"},{"id":"200","pinyin_key":"M","pinyin":"mi"},{"id":"201","pinyin_key":"M","pinyin":"mian"},{"id":"202","pinyin_key":"M","pinyin":"miao"},{"id":"203","pinyin_key":"M","pinyin":"mie"},{"id":"204","pinyin_key":"M","pinyin":"min"},{"id":"205","pinyin_key":"M","pinyin":"ming"},{"id":"206","pinyin_key":"M","pinyin":"miu"},{"id":"207","pinyin_key":"M","pinyin":"mo"},{"id":"208","pinyin_key":"M","pinyin":"mou"},{"id":"209","pinyin_key":"M","pinyin":"mu"},{"id":"210","pinyin_key":"N","pinyin":"na"},{"id":"211","pinyin_key":"N","pinyin":"nai"},{"id":"212","pinyin_key":"N","pinyin":"nan"},{"id":"213","pinyin_key":"N","pinyin":"nang"},{"id":"214","pinyin_key":"N","pinyin":"nao"},{"id":"215","pinyin_key":"N","pinyin":"ne"},{"id":"216","pinyin_key":"N","pinyin":"nei"},{"id":"217","pinyin_key":"N","pinyin":"nen"},{"id":"218","pinyin_key":"N","pinyin":"neng"},{"id":"219","pinyin_key":"N","pinyin":"ng"},{"id":"220","pinyin_key":"N","pinyin":"ni"},{"id":"221","pinyin_key":"N","pinyin":"nian"},{"id":"222","pinyin_key":"N","pinyin":"niang"},{"id":"223","pinyin_key":"N","pinyin":"niao"},{"id":"224","pinyin_key":"N","pinyin":"nie"},{"id":"225","pinyin_key":"N","pinyin":"nin"},{"id":"226","pinyin_key":"N","pinyin":"ning"},{"id":"227","pinyin_key":"N","pinyin":"niu"},{"id":"228","pinyin_key":"N","pinyin":"nong"},{"id":"229","pinyin_key":"N","pinyin":"nou"},{"id":"230","pinyin_key":"N","pinyin":"nu"},{"id":"231","pinyin_key":"N","pinyin":"nü"},{"id":"232","pinyin_key":"N","pinyin":"nuan"},{"id":"233","pinyin_key":"N","pinyin":"nüe"},{"id":"234","pinyin_key":"N","pinyin":"nuo"},{"id":"235","pinyin_key":"N","pinyin":"nun"},{"id":"236","pinyin_key":"O","pinyin":"o"},{"id":"237","pinyin_key":"O","pinyin":"ou"},{"id":"238","pinyin_key":"P","pinyin":"pa"},{"id":"239","pinyin_key":"P","pinyin":"pai"},{"id":"240","pinyin_key":"P","pinyin":"pan"},{"id":"241","pinyin_key":"P","pinyin":"pang"},{"id":"242","pinyin_key":"P","pinyin":"pao"},{"id":"243","pinyin_key":"P","pinyin":"pei"},{"id":"244","pinyin_key":"P","pinyin":"pen"},{"id":"245","pinyin_key":"P","pinyin":"peng"},{"id":"246","pinyin_key":"P","pinyin":"pi"},{"id":"247","pinyin_key":"P","pinyin":"pian"},{"id":"248","pinyin_key":"P","pinyin":"piao"},{"id":"249","pinyin_key":"P","pinyin":"pie"},{"id":"250","pinyin_key":"P","pinyin":"pin"},{"id":"251","pinyin_key":"P","pinyin":"ping"},{"id":"252","pinyin_key":"P","pinyin":"po"},{"id":"253","pinyin_key":"P","pinyin":"pou"},{"id":"254","pinyin_key":"P","pinyin":"pu"},{"id":"255","pinyin_key":"Q","pinyin":"qi"},{"id":"256","pinyin_key":"Q","pinyin":"qia"},{"id":"257","pinyin_key":"Q","pinyin":"qian"},{"id":"258","pinyin_key":"Q","pinyin":"qiang"},{"id":"259","pinyin_key":"Q","pinyin":"qiao"},{"id":"260","pinyin_key":"Q","pinyin":"qie"},{"id":"261","pinyin_key":"Q","pinyin":"qin"},{"id":"262","pinyin_key":"Q","pinyin":"qing"},{"id":"263","pinyin_key":"Q","pinyin":"qiong"},{"id":"264","pinyin_key":"Q","pinyin":"qiu"},{"id":"265","pinyin_key":"Q","pinyin":"qu"},{"id":"266","pinyin_key":"Q","pinyin":"quan"},{"id":"267","pinyin_key":"Q","pinyin":"que"},{"id":"268","pinyin_key":"Q","pinyin":"qun"},{"id":"269","pinyin_key":"R","pinyin":"ran"},{"id":"270","pinyin_key":"R","pinyin":"rang"},{"id":"271","pinyin_key":"R","pinyin":"rao"},{"id":"272","pinyin_key":"R","pinyin":"re"},{"id":"273","pinyin_key":"R","pinyin":"ren"},{"id":"274","pinyin_key":"R","pinyin":"reng"},{"id":"275","pinyin_key":"R","pinyin":"ri"},{"id":"276","pinyin_key":"R","pinyin":"rong"},{"id":"277","pinyin_key":"R","pinyin":"rou"},{"id":"278","pinyin_key":"R","pinyin":"ru"},{"id":"279","pinyin_key":"R","pinyin":"ruan"},{"id":"280","pinyin_key":"R","pinyin":"rui"},{"id":"281","pinyin_key":"R","pinyin":"run"},{"id":"282","pinyin_key":"R","pinyin":"ruo"},{"id":"283","pinyin_key":"S","pinyin":"sa"},{"id":"284","pinyin_key":"S","pinyin":"sai"},{"id":"285","pinyin_key":"S","pinyin":"san"},{"id":"286","pinyin_key":"S","pinyin":"sang"},{"id":"287","pinyin_key":"S","pinyin":"sao"},{"id":"288","pinyin_key":"S","pinyin":"se"},{"id":"289","pinyin_key":"S","pinyin":"sen"},{"id":"290","pinyin_key":"S","pinyin":"seng"},{"id":"291","pinyin_key":"S","pinyin":"sha"},{"id":"292","pinyin_key":"S","pinyin":"shai"},{"id":"293","pinyin_key":"S","pinyin":"shan"},{"id":"294","pinyin_key":"S","pinyin":"shang"},{"id":"295","pinyin_key":"S","pinyin":"shao"},{"id":"296","pinyin_key":"S","pinyin":"she"},{"id":"297","pinyin_key":"S","pinyin":"shei"},{"id":"298","pinyin_key":"S","pinyin":"shen"},{"id":"299","pinyin_key":"S","pinyin":"sheng"},{"id":"300","pinyin_key":"S","pinyin":"shi"},{"id":"301","pinyin_key":"S","pinyin":"shou"},{"id":"302","pinyin_key":"S","pinyin":"shu"},{"id":"303","pinyin_key":"S","pinyin":"shua"},{"id":"304","pinyin_key":"S","pinyin":"shuai"},{"id":"305","pinyin_key":"S","pinyin":"shuan"},{"id":"306","pinyin_key":"S","pinyin":"shuang"},{"id":"307","pinyin_key":"S","pinyin":"shui"},{"id":"308","pinyin_key":"S","pinyin":"shun"},{"id":"309","pinyin_key":"S","pinyin":"shuo"},{"id":"310","pinyin_key":"S","pinyin":"si"},{"id":"311","pinyin_key":"S","pinyin":"song"},{"id":"312","pinyin_key":"S","pinyin":"sou"},{"id":"313","pinyin_key":"S","pinyin":"su"},{"id":"314","pinyin_key":"S","pinyin":"suan"},{"id":"315","pinyin_key":"S","pinyin":"sui"},{"id":"316","pinyin_key":"S","pinyin":"sun"},{"id":"317","pinyin_key":"S","pinyin":"suo"},{"id":"318","pinyin_key":"T","pinyin":"ta"},{"id":"319","pinyin_key":"T","pinyin":"tai"},{"id":"320","pinyin_key":"T","pinyin":"tan"},{"id":"321","pinyin_key":"T","pinyin":"tang"},{"id":"322","pinyin_key":"T","pinyin":"tao"},{"id":"323","pinyin_key":"T","pinyin":"te"},{"id":"324","pinyin_key":"T","pinyin":"teng"},{"id":"325","pinyin_key":"T","pinyin":"ti"},{"id":"326","pinyin_key":"T","pinyin":"tian"},{"id":"327","pinyin_key":"T","pinyin":"tiao"},{"id":"328","pinyin_key":"T","pinyin":"tie"},{"id":"329","pinyin_key":"T","pinyin":"ting"},{"id":"330","pinyin_key":"T","pinyin":"tong"},{"id":"331","pinyin_key":"T","pinyin":"tou"},{"id":"332","pinyin_key":"T","pinyin":"tu"},{"id":"333","pinyin_key":"T","pinyin":"tuan"},{"id":"334","pinyin_key":"T","pinyin":"tui"},{"id":"335","pinyin_key":"T","pinyin":"tun"},{"id":"336","pinyin_key":"T","pinyin":"tuo"},{"id":"337","pinyin_key":"W","pinyin":"wa"},{"id":"338","pinyin_key":"W","pinyin":"wai"},{"id":"339","pinyin_key":"W","pinyin":"wan"},{"id":"340","pinyin_key":"W","pinyin":"wang"},{"id":"341","pinyin_key":"W","pinyin":"wei"},{"id":"342","pinyin_key":"W","pinyin":"wen"},{"id":"343","pinyin_key":"W","pinyin":"weng"},{"id":"344","pinyin_key":"W","pinyin":"wo"},{"id":"345","pinyin_key":"W","pinyin":"wu"},{"id":"346","pinyin_key":"X","pinyin":"xi"},{"id":"347","pinyin_key":"X","pinyin":"xia"},{"id":"348","pinyin_key":"X","pinyin":"xian"},{"id":"349","pinyin_key":"X","pinyin":"xiang"},{"id":"350","pinyin_key":"X","pinyin":"xiao"},{"id":"351","pinyin_key":"X","pinyin":"xie"},{"id":"352","pinyin_key":"X","pinyin":"xin"},{"id":"353","pinyin_key":"X","pinyin":"xing"},{"id":"354","pinyin_key":"X","pinyin":"xiong"},{"id":"355","pinyin_key":"X","pinyin":"xiu"},{"id":"356","pinyin_key":"X","pinyin":"xu"},{"id":"357","pinyin_key":"X","pinyin":"xuan"},{"id":"358","pinyin_key":"X","pinyin":"xue"},{"id":"359","pinyin_key":"X","pinyin":"xun"},{"id":"360","pinyin_key":"Y","pinyin":"ya"},{"id":"361","pinyin_key":"Y","pinyin":"yan"},{"id":"362","pinyin_key":"Y","pinyin":"yang"},{"id":"363","pinyin_key":"Y","pinyin":"yao"},{"id":"364","pinyin_key":"Y","pinyin":"ye"},{"id":"365","pinyin_key":"Y","pinyin":"yi"},{"id":"366","pinyin_key":"Y","pinyin":"yin"},{"id":"367","pinyin_key":"Y","pinyin":"ying"},{"id":"368","pinyin_key":"Y","pinyin":"yo"},{"id":"369","pinyin_key":"Y","pinyin":"yong"},{"id":"370","pinyin_key":"Y","pinyin":"you"},{"id":"371","pinyin_key":"Y","pinyin":"yu"},{"id":"372","pinyin_key":"Y","pinyin":"yuan"},{"id":"373","pinyin_key":"Y","pinyin":"yue"},{"id":"374","pinyin_key":"Y","pinyin":"yun"},{"id":"375","pinyin_key":"Z","pinyin":"za"},{"id":"376","pinyin_key":"Z","pinyin":"zai"},{"id":"377","pinyin_key":"Z","pinyin":"zan"},{"id":"378","pinyin_key":"Z","pinyin":"zang"},{"id":"379","pinyin_key":"Z","pinyin":"zao"},{"id":"380","pinyin_key":"Z","pinyin":"ze"},{"id":"381","pinyin_key":"Z","pinyin":"zei"},{"id":"382","pinyin_key":"Z","pinyin":"zen"},{"id":"383","pinyin_key":"Z","pinyin":"zeng"},{"id":"384","pinyin_key":"Z","pinyin":"zha"},{"id":"385","pinyin_key":"Z","pinyin":"zhai"},{"id":"386","pinyin_key":"Z","pinyin":"zhan"},{"id":"387","pinyin_key":"Z","pinyin":"zhang"},{"id":"388","pinyin_key":"Z","pinyin":"zhao"},{"id":"389","pinyin_key":"Z","pinyin":"zhe"},{"id":"390","pinyin_key":"Z","pinyin":"zhei"},{"id":"391","pinyin_key":"Z","pinyin":"zhen"},{"id":"392","pinyin_key":"Z","pinyin":"zheng"},{"id":"393","pinyin_key":"Z","pinyin":"zhi"},{"id":"394","pinyin_key":"Z","pinyin":"zhong"},{"id":"395","pinyin_key":"Z","pinyin":"zhou"},{"id":"396","pinyin_key":"Z","pinyin":"zhu"},{"id":"397","pinyin_key":"Z","pinyin":"zhua"},{"id":"398","pinyin_key":"Z","pinyin":"zhuai"},{"id":"399","pinyin_key":"Z","pinyin":"zhuan"},{"id":"400","pinyin_key":"Z","pinyin":"zhuang"},{"id":"401","pinyin_key":"Z","pinyin":"zhui"},{"id":"402","pinyin_key":"Z","pinyin":"zhun"},{"id":"403","pinyin_key":"Z","pinyin":"zhuo"},{"id":"404","pinyin_key":"Z","pinyin":"zi"},{"id":"405","pinyin_key":"Z","pinyin":"zong"},{"id":"406","pinyin_key":"Z","pinyin":"zou"},{"id":"407","pinyin_key":"Z","pinyin":"zu"},{"id":"408","pinyin_key":"Z","pinyin":"zuan"},{"id":"409","pinyin_key":"Z","pinyin":"zui"},{"id":"410","pinyin_key":"Z","pinyin":"zun"},{"id":"411","pinyin_key":"Z","pinyin":"zuo"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * pinyin_key : A
         * pinyin : a
         * bihua : 1
         * bushou : 丨
         */

        private String id;
        private String pinyin_key;
        private String pinyin;
        private String bihua;
        private String bushou;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPinyin_key() {
            return pinyin_key;
        }

        public void setPinyin_key(String pinyin_key) {
            this.pinyin_key = pinyin_key;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getBihua() {
            return bihua;
        }

        public void setBihua(String bihua) {
            this.bihua = bihua;
        }

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }
    }
}
