package com.yanyin.maoyan.move.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 颜银 on 2016/11/30.
 * QQ:443098360
 * 微信：y443098360
 * 作用：热映ListView的Bean类
 */

public class ListViewBean  {

    /**
     * expires : 1800
     */

    private ControlBean control;
    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"late":false,"showInfo":"今天165家影院放映2088场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":236,"scm":"神奇动物城，法师显超能","imax":true,"snum":99535,"nm":"神奇动物在哪里","dur":133,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","sc":9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","id":248918,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"新海诚","star":"上白石萌音,神木隆之介,长泽雅美","cat":"剧情,爱情,动画","wish":255626,"3d":false,"pn":166,"scm":"寻君千里行，心系君之名","imax":false,"snum":17504,"nm":"你的名字。","dur":107,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":344881,"time":""},{"late":false,"showInfo":"今天162家影院放映960场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"scm":"航海家后代，征程向大海","imax":false,"snum":30745,"nm":"海洋奇缘","dur":107,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","sc":9.2,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","id":246222,"time":""},{"late":false,"showInfo":"今天154家影院放映953场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"罗伯特·泽米吉斯","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","cat":"爱情,动作,战争","wish":42631,"3d":false,"pn":210,"scm":"夫妇皆仇敌，枕边藏杀机","imax":false,"snum":28905,"nm":"间谍同盟","dur":124,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","sc":8.7,"ver":"2D/中国巨幕","rt":"本周三上映","id":346564,"time":""},{"late":false,"showInfo":"今天158家影院放映806场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"scm":"金莲戏中戏，官场局中局","imax":false,"snum":180928,"nm":"我不是潘金莲","dur":140,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","sc":7.9,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","id":341749,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"蒂姆·波顿","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","cat":"冒险,奇幻","wish":98236,"3d":true,"pn":107,"scm":"异能桃花源，穿越时光圈","imax":false,"snum":1190,"nm":"佩小姐的奇幻城堡","dur":126,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","sc":0,"ver":"2D/3D/中国巨幕/全景声","rt":"本周五上映","id":246373,"time":""},{"late":false,"showInfo":"今天115家影院放映332场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"静野孔文","star":"高山南,天海佑希,林原惠美","cat":"动画,悬疑","wish":43219,"3d":false,"pn":80,"scm":"美女有异瞳，黑暗再行动","imax":false,"snum":19321,"nm":"名侦探柯南：纯黑的恶梦","dur":112,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","sc":8.8,"ver":"2D","rt":"2016-11-25上映","id":344073,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"尔冬升","star":"林更新,何润东,蒋梦婕","cat":"剧情,动作,武侠","wish":94819,"3d":true,"pn":115,"scm":"冬升携老怪，千仗无一败","imax":false,"snum":1193,"nm":"三少爷的剑","dur":107,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","sc":0,"ver":"3D/中国巨幕","rt":"本周五上映","id":79088,"time":""},{"late":false,"showInfo":"今天74家影院放映195场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"斯科特·德瑞克森","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","cat":"动作,冒险,奇幻","wish":205273,"3d":true,"pn":534,"scm":"车祸手迟钝，修炼成神棍","imax":true,"snum":335420,"nm":"奇异博士","dur":115,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","sc":9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-11-04上映","id":246124,"time":""},{"late":false,"showInfo":"今天73家影院放映150场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林岭东,钱文锜","star":"吴彦祖,张孝全,张若昀","cat":"剧情,动作,悬疑","wish":29674,"3d":false,"pn":188,"scm":"血清三路抢，大火吞真相","imax":false,"snum":20656,"nm":"冲天火","dur":100,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","sc":7.1,"ver":"2D","rt":"2016-11-25上映","id":341529,"time":""},{"late":false,"showInfo":"今天44家影院放映106场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"李安","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","cat":"剧情,战争","wish":33615,"3d":true,"pn":281,"scm":"半场无战事，少年初长时","imax":false,"snum":55062,"nm":"比利·林恩的中场战事","dur":113,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","sc":8.3,"ver":"3D/中国巨幕","rt":"2016-11-11上映","id":247736,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"宋啸","star":"陈赫,宋智孝,大卫·贝利","cat":"喜剧,动作,冒险","wish":42417,"3d":false,"pn":143,"scm":"中法韩跑男，为夺宝闯关","imax":false,"snum":1597,"nm":"超级快递","dur":91,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","sc":0,"ver":"2D/中国巨幕","rt":"本周五上映","id":343866,"time":""},{"late":false,"showInfo":"2016-12-08 下周四上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":13072,"3d":false,"pn":98,"scm":"士兵有信仰，战场拒拿枪","imax":false,"snum":222,"nm":"血战钢锯岭","dur":139,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","sc":0,"ver":"2D/中国巨幕","rt":"下周四上映","id":338349,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"李凯","star":"娄淇,杨凯迪,谢波","cat":"恐怖,惊悚,科幻","wish":7231,"3d":false,"pn":47,"scm":"驴友去探险，误闯食人岛","imax":false,"snum":135,"nm":"食人岛","dur":94,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":1132403,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"周隼","star":"胡歌,宋佳,颜卓灵","cat":"爱情,悬疑,犯罪","wish":30631,"3d":false,"pn":52,"scm":"绑架十二年，归家惹事端","imax":false,"snum":727,"nm":"那年夏天你去了哪里","dur":0,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","sc":0,"ver":"2D","rt":"下周五上映","id":1187526,"time":""},{"late":false,"showInfo":"今天5家影院放映28场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘镇伟","star":"韩庚,唐嫣,吴京","cat":"喜剧,奇幻,爱情","wish":287204,"3d":true,"pn":200,"scm":"至尊宝归来，穿越寻真爱","imax":false,"snum":292538,"nm":"大话西游3","dur":93,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/c5c37139438c203a623e95d71a0181f0919589.jpg","sc":7,"ver":"2D/3D/中国巨幕","rt":"2016-09-14上映","id":247259,"time":""},{"late":false,"showInfo":"今天23家影院放映28场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"马侃","star":"高以翔,王水林,秦晓飞","cat":"喜剧,爱情","wish":40251,"3d":false,"pn":72,"scm":"身高有差距，恋爱零距离","imax":false,"snum":5677,"nm":"最萌身高差","dur":91,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","sc":7.8,"ver":"2D","rt":"2016-11-25上映","id":345105,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"埃兰·克里维","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","cat":"动作,惊悚","wish":20008,"3d":true,"pn":90,"scm":"舍命战毒枭，为爱去狂飙","imax":false,"snum":94,"nm":"极速之巅","dur":88,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","sc":0,"ver":"2D/中国巨幕/3D","rt":"本周五上映","id":336835,"time":""},{"late":false,"showInfo":"今天13家影院放映21场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"彼得·博格","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","cat":"剧情,动作,灾难","wish":26131,"3d":false,"pn":228,"scm":"海上遇井喷，英勇救同伴","imax":false,"snum":30761,"nm":"深海浩劫","dur":108,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","sc":8.3,"ver":"2D/中国巨幕","rt":"2016-11-15上映","id":248675,"time":""},{"late":false,"showInfo":"今天21家影院放映21场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"周广兴","star":"那威,倪新宇,陈美行","cat":"恐怖,惊悚,悬疑","wish":17215,"3d":false,"pn":33,"scm":"夫人突暴毙，地下藏玄机","imax":false,"snum":2067,"nm":"怨灵地下室","dur":89,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","sc":3.3,"ver":"2D","rt":"2016-11-25上映","id":1182756,"time":""},{"late":false,"showInfo":"今天13家影院放映20场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林超贤","star":"张涵予,彭于晏,冯文娟","cat":"动作,犯罪,剧情","wish":57407,"3d":false,"pn":296,"scm":"商船藏毒品，冤屈难洗清","imax":false,"snum":821394,"nm":"湄公河行动","dur":124,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","sc":9.3,"ver":"2D/中国巨幕","rt":"2016-09-30上映","id":338391,"time":""},{"late":false,"showInfo":"今天11家影院放映20场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"宫元宏彰","star":"田中真弓,大谷育江,冈村明美","cat":"动画,冒险","wish":118442,"3d":false,"pn":108,"scm":"热血海贼王，冒险新起航","imax":false,"snum":96216,"nm":"航海王之黄金城","dur":121,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","sc":9.1,"ver":"2D","rt":"2016-11-11上映","id":344902,"time":""},{"late":false,"showInfo":"今天15家影院放映16场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林浩然","star":"陈妍希,杰克逊·拉斯波恩,成康","cat":"剧情,爱情,悬疑","wish":11823,"3d":false,"pn":39,"scm":"只是被车撞，生活却变样","imax":false,"snum":594,"nm":"夏威夷之恋","dur":95,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","sc":7.3,"ver":"2D","rt":"2016-11-25上映","id":337195,"time":""},{"late":false,"showInfo":"今天3家影院放映11场","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"张末","star":"倪妮,霍建华,马苏","cat":"喜剧,爱情,奇幻","wish":91691,"3d":false,"pn":140,"scm":"哭成小笨蛋，笑回长大前","imax":false,"snum":71,"nm":"28岁未成年","dur":109,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","sc":9.3,"ver":"2D","rt":"下周五上映","id":343413,"time":""},{"late":false,"showInfo":"今天10家影院放映15场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"周申,刘露","star":"任素汐,大力,刘帅良","cat":"剧情,喜剧","wish":29385,"3d":false,"pn":157,"scm":"谎言圆不上，人比驴荒唐","imax":false,"snum":135645,"nm":"驴得水","dur":111,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","sc":8.5,"ver":"2D","rt":"2016-10-28上映","id":410612,"time":""},{"late":false,"showInfo":"今天13家影院放映15场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"陈兵","star":"安宰贤,安以轩,方中信","cat":"剧情,爱情","wish":20845,"3d":false,"pn":70,"scm":"处女爱处男，结局并不惨","imax":false,"snum":1553,"nm":"我是处女座","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","sc":7.9,"ver":"2D","rt":"2016-11-25上映","id":344437,"time":""},{"late":false,"showInfo":"2016-12-01 本周四上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"谢云鹏,杜昌博","star":"郑昊,张墨锡,王佳琦","cat":"剧情,爱情","wish":2122,"3d":false,"pn":265,"scm":"女孩遭性侵，山村来打拼","imax":false,"snum":68,"nm":"爱你的人","dur":92,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","sc":0,"ver":"2D","rt":"本周四上映","id":345529,"time":""},{"late":false,"showInfo":"今天5家影院放映8场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"郭翔","star":"马德钟,王大治,刘力扬","cat":"剧情,喜剧,爱情","wish":3016,"3d":false,"pn":77,"scm":"不惑未婚男，追女赴越南","imax":false,"snum":246,"nm":"越囧","dur":96,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","sc":0,"ver":"2D","rt":"2016-11-25上映","id":246674,"time":""},{"late":false,"showInfo":"今天6家影院放映7场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"安兵基","star":"佟大为,陈妍希,吕云骢","cat":"剧情,喜剧,家庭","wish":39153,"3d":false,"pn":166,"scm":"主播有点烦，儿孙太能缠","imax":false,"snum":36962,"nm":"外公芳龄38","dur":103,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","sc":8.3,"ver":"2D","rt":"2016-11-11上映","id":342427,"time":""},{"late":false,"showInfo":"今天4家影院放映6场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"亚瑟·本扎昆","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","cat":"喜剧,爱情","wish":19648,"3d":false,"pn":76,"scm":"穷人爱公主，神灯来帮助","imax":false,"snum":11089,"nm":"阿拉丁与神灯","dur":101,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","sc":7.4,"ver":"2D","rt":"2016-11-18上映","id":346365,"time":""},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"宁海强","star":"李东学,聂远,于小伟","cat":"历史,战争,动作","wish":10456,"3d":false,"pn":134,"scm":"夜奔百余里，行军创奇迹","imax":false,"snum":17413,"nm":"勇士","dur":102,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","sc":8.8,"ver":"2D/中国巨幕","rt":"2016-10-14上映","id":346759,"time":""},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"马蒂亚斯·霍恩","star":"赵又廷,倪妮,尤赖亚·谢尔顿","cat":"动作,冒险,奇幻","wish":23294,"3d":true,"pn":212,"scm":"异世来相逢，勇者得重生","imax":false,"snum":19291,"nm":"勇士之门","dur":108,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","sc":6.5,"ver":"2D/3D/中国巨幕","rt":"2016-11-18上映","id":248637,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"克林特·伊斯特伍德","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","cat":"剧情,传记","wish":12510,"3d":false,"pn":79,"scm":"飞机遇意外，机长险被害","imax":true,"snum":194,"nm":"萨利机长","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","sc":0,"ver":"2D/IMAX 2D/中国巨幕","rt":"下周五上映","id":342003,"time":""},{"late":false,"showInfo":"今天1家影院放映2场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘雨霖","star":"毛孩,李倩,刘蓓","cat":"剧情","wish":11050,"3d":false,"pn":176,"scm":"婚后无话讲，与谁诉短长","imax":false,"snum":6787,"nm":"一句顶一万句","dur":110,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","sc":7.7,"ver":"2D","rt":"2016-11-04上映","id":345216,"time":""},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"钟萱","star":"钟萱,温兆伦,刘宇珽","cat":"恐怖,惊悚,悬疑","wish":4173,"3d":false,"pn":47,"scm":"神秘白云桥，阴阳交界处","imax":false,"snum":2364,"nm":"白云桥","dur":94,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","sc":5.9,"ver":"2D","rt":"2016-11-18上映","id":1187417,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"蒋钦民","star":"袁成杰,曹云金,江若琳","cat":"剧情,喜剧,爱情","wish":16812,"3d":false,"pn":35,"scm":"新郎要逃婚，中了大陷阱","imax":false,"snum":828,"nm":"不离不弃","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","sc":7.3,"ver":"2D","rt":"2016-11-04上映","id":345494,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘杰","star":"霍建华,秦海璐,万茜","cat":"惊悚,悬疑,犯罪","wish":42092,"3d":false,"pn":153,"scm":"哥哥久失踪，符号引惶恐","imax":false,"snum":53281,"nm":"捉迷藏","dur":105,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/584a35567b3baecfe7347481ba09d9a8418043.jpg","sc":8.2,"ver":"2D","rt":"2016-11-04上映","id":346299,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"朱员成","star":"颜丙燕,王德顺,艾丽娅","cat":"剧情","wish":9000,"3d":false,"pn":55,"scm":"时光终将老，陪伴少不了","imax":false,"snum":289,"nm":"盛先生的花儿","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/447cc8fdcac0d0bcfaeca531b9f49ed2591404.jpg","sc":8.2,"ver":"2D","rt":"2016-11-04上映","id":621219,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"苑本立","star":"聂远,叶一云","cat":"剧情","wish":46,"3d":false,"pn":11,"scm":"红军开道路，迎接大部队","imax":false,"snum":54,"nm":"生死96小时","dur":97,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/e6bc541ab839d55e868948f850bc1d9c141987.jpg","sc":0,"ver":"2D","rt":"2016-11-09上映","id":1196221,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"张坚庭","star":"郑嘉颖,小小彬,李呈媛","cat":"剧情,喜剧,爱情","wish":16655,"3d":false,"pn":61,"scm":"育儿新绝招，假装被破产","imax":false,"snum":1932,"nm":"贫穷富爸爸","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","sc":8.2,"ver":"2D","rt":"2016-11-10上映","id":336061,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"崔志敏","star":"邹德江,章宇,卢倩文","cat":"剧情,战争","wish":7,"3d":false,"pn":7,"scm":"燕赵大地上，鬼子无处藏","imax":false,"snum":8,"nm":"热土悲歌","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","sc":0,"ver":"2D","rt":"2016-11-25上映","id":1189305,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"李柯","star":"隋咏良,尤靖茹,薛祺","cat":"剧情,爱情,冒险","wish":2178,"3d":false,"pn":68,"scm":"沙漠越野赛，飙车为求爱","imax":false,"snum":15,"nm":"沙漠之心","dur":94,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":1197460,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"万玛才旦","star":"西德尼玛,杨秀措,扎西","cat":"剧情","wish":2137,"3d":false,"pn":44,"scm":"牧羊人进城，打碎纯真梦","imax":false,"snum":426,"nm":"塔洛","dur":120,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","sc":0,"ver":"2D","rt":"下周五上映","id":337708,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"孙亮","star":"吴镇宇,戴立忍,李昕芸","cat":"悬疑,剧情","wish":5709,"3d":false,"pn":88,"scm":"医生有武器，心计和身体","imax":false,"snum":1348,"nm":"判我有罪","dur":102,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","sc":6.5,"ver":"2D","rt":"2016-05-06上映","id":343082,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"毕赣","star":"陈永忠,郭月,余世学","cat":"剧情,悬疑","wish":5647,"3d":false,"pn":95,"scm":"离家把侄寻，帮人带书信","imax":false,"snum":6049,"nm":"路边野餐","dur":113,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","sc":8.1,"ver":"2D","rt":"2016-07-15上映","id":342073,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"摩撒利","star":"殷果儿,丁汇宇,刘小奇","cat":"爱情,惊悚,悬疑","wish":17879,"3d":false,"pn":34,"scm":"东方魔幻书，怪力乱神出","imax":false,"snum":4416,"nm":"聊斋新编之画皮新娘","dur":88,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","sc":5,"ver":"2D","rt":"2016-11-11上映","id":346546,"time":""}]}
     */

    private int status;
    /**
     * hasNext : false
     * movies : [{"late":false,"showInfo":"今天165家影院放映2088场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":236,"scm":"神奇动物城，法师显超能","imax":true,"snum":99535,"nm":"神奇动物在哪里","dur":133,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","sc":9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","id":248918,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"新海诚","star":"上白石萌音,神木隆之介,长泽雅美","cat":"剧情,爱情,动画","wish":255626,"3d":false,"pn":166,"scm":"寻君千里行，心系君之名","imax":false,"snum":17504,"nm":"你的名字。","dur":107,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":344881,"time":""},{"late":false,"showInfo":"今天162家影院放映960场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,Rachel House","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"scm":"航海家后代，征程向大海","imax":false,"snum":30745,"nm":"海洋奇缘","dur":107,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","sc":9.2,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","id":246222,"time":""},{"late":false,"showInfo":"今天154家影院放映953场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"罗伯特·泽米吉斯","star":"布拉德·皮特,玛丽昂·歌迪亚,马修·古迪","cat":"爱情,动作,战争","wish":42631,"3d":false,"pn":210,"scm":"夫妇皆仇敌，枕边藏杀机","imax":false,"snum":28905,"nm":"间谍同盟","dur":124,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/9aa8a2df88d43ad08fbf0d1c6878bb5579675.jpg","sc":8.7,"ver":"2D/中国巨幕","rt":"本周三上映","id":346564,"time":""},{"late":false,"showInfo":"今天158家影院放映806场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"scm":"金莲戏中戏，官场局中局","imax":false,"snum":180928,"nm":"我不是潘金莲","dur":140,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","sc":7.9,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","id":341749,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"蒂姆·波顿","star":"伊娃·格林,阿沙·巴特菲尔德,塞缪尔·杰克逊","cat":"冒险,奇幻","wish":98236,"3d":true,"pn":107,"scm":"异能桃花源，穿越时光圈","imax":false,"snum":1190,"nm":"佩小姐的奇幻城堡","dur":126,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","sc":0,"ver":"2D/3D/中国巨幕/全景声","rt":"本周五上映","id":246373,"time":""},{"late":false,"showInfo":"今天115家影院放映332场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"静野孔文","star":"高山南,天海佑希,林原惠美","cat":"动画,悬疑","wish":43219,"3d":false,"pn":80,"scm":"美女有异瞳，黑暗再行动","imax":false,"snum":19321,"nm":"名侦探柯南：纯黑的恶梦","dur":112,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/6742d5169d136a58a3b1ca2fd071e88c248086.jpg","sc":8.8,"ver":"2D","rt":"2016-11-25上映","id":344073,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"尔冬升","star":"林更新,何润东,蒋梦婕","cat":"剧情,动作,武侠","wish":94819,"3d":true,"pn":115,"scm":"冬升携老怪，千仗无一败","imax":false,"snum":1193,"nm":"三少爷的剑","dur":107,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","sc":0,"ver":"3D/中国巨幕","rt":"本周五上映","id":79088,"time":""},{"late":false,"showInfo":"今天74家影院放映195场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"斯科特·德瑞克森","star":"本尼迪克特·康伯巴奇,切瓦特·埃加福特,瑞秋·麦克亚当斯","cat":"动作,冒险,奇幻","wish":205273,"3d":true,"pn":534,"scm":"车祸手迟钝，修炼成神棍","imax":true,"snum":335420,"nm":"奇异博士","dur":115,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/aa492b57443fc95a5b3b46c459d59e50898549.jpg","sc":9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2016-11-04上映","id":246124,"time":""},{"late":false,"showInfo":"今天73家影院放映150场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林岭东,钱文锜","star":"吴彦祖,张孝全,张若昀","cat":"剧情,动作,悬疑","wish":29674,"3d":false,"pn":188,"scm":"血清三路抢，大火吞真相","imax":false,"snum":20656,"nm":"冲天火","dur":100,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/a4469e30fc41d262ad021d5dd0dd73aa767743.jpg","sc":7.1,"ver":"2D","rt":"2016-11-25上映","id":341529,"time":""},{"late":false,"showInfo":"今天44家影院放映106场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"李安","star":"乔·阿尔文,克里斯汀·斯图尔特,加内特·赫德兰","cat":"剧情,战争","wish":33615,"3d":true,"pn":281,"scm":"半场无战事，少年初长时","imax":false,"snum":55062,"nm":"比利·林恩的中场战事","dur":113,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/0469a4bbcf69d46357256bc100bed703787664.jpg","sc":8.3,"ver":"3D/中国巨幕","rt":"2016-11-11上映","id":247736,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"宋啸","star":"陈赫,宋智孝,大卫·贝利","cat":"喜剧,动作,冒险","wish":42417,"3d":false,"pn":143,"scm":"中法韩跑男，为夺宝闯关","imax":false,"snum":1597,"nm":"超级快递","dur":91,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","sc":0,"ver":"2D/中国巨幕","rt":"本周五上映","id":343866,"time":""},{"late":false,"showInfo":"2016-12-08 下周四上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":13072,"3d":false,"pn":98,"scm":"士兵有信仰，战场拒拿枪","imax":false,"snum":222,"nm":"血战钢锯岭","dur":139,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/9581cfbc221ab927b6c856524e96d319769553.jpg","sc":0,"ver":"2D/中国巨幕","rt":"下周四上映","id":338349,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"李凯","star":"娄淇,杨凯迪,谢波","cat":"恐怖,惊悚,科幻","wish":7231,"3d":false,"pn":47,"scm":"驴友去探险，误闯食人岛","imax":false,"snum":135,"nm":"食人岛","dur":94,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/99b80de56746a9de620f08cb33bd21e15407178.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":1132403,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"周隼","star":"胡歌,宋佳,颜卓灵","cat":"爱情,悬疑,犯罪","wish":30631,"3d":false,"pn":52,"scm":"绑架十二年，归家惹事端","imax":false,"snum":727,"nm":"那年夏天你去了哪里","dur":0,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d4def49e4f1b238c939334f8915bd8ac829204.png","sc":0,"ver":"2D","rt":"下周五上映","id":1187526,"time":""},{"late":false,"showInfo":"今天5家影院放映28场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘镇伟","star":"韩庚,唐嫣,吴京","cat":"喜剧,奇幻,爱情","wish":287204,"3d":true,"pn":200,"scm":"至尊宝归来，穿越寻真爱","imax":false,"snum":292538,"nm":"大话西游3","dur":93,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/c5c37139438c203a623e95d71a0181f0919589.jpg","sc":7,"ver":"2D/3D/中国巨幕","rt":"2016-09-14上映","id":247259,"time":""},{"late":false,"showInfo":"今天23家影院放映28场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"马侃","star":"高以翔,王水林,秦晓飞","cat":"喜剧,爱情","wish":40251,"3d":false,"pn":72,"scm":"身高有差距，恋爱零距离","imax":false,"snum":5677,"nm":"最萌身高差","dur":91,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/63df54245e2a87bcbe4d9f7a4ee496e6963165.jpg","sc":7.8,"ver":"2D","rt":"2016-11-25上映","id":345105,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"埃兰·克里维","star":"尼古拉斯·霍尔特,菲丽希缇·琼斯,Johny Mathew","cat":"动作,惊悚","wish":20008,"3d":true,"pn":90,"scm":"舍命战毒枭，为爱去狂飙","imax":false,"snum":94,"nm":"极速之巅","dur":88,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/394490e44943bebd375ffae1a7fe113e492426.jpg","sc":0,"ver":"2D/中国巨幕/3D","rt":"本周五上映","id":336835,"time":""},{"late":false,"showInfo":"今天13家影院放映21场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"彼得·博格","star":"马克·沃尔伯格,吉娜·罗德里格兹,库尔特·拉塞尔","cat":"剧情,动作,灾难","wish":26131,"3d":false,"pn":228,"scm":"海上遇井喷，英勇救同伴","imax":false,"snum":30761,"nm":"深海浩劫","dur":108,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c8d8a0a51af8da4489727296ebf2d548617916.jpg","sc":8.3,"ver":"2D/中国巨幕","rt":"2016-11-15上映","id":248675,"time":""},{"late":false,"showInfo":"今天21家影院放映21场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"周广兴","star":"那威,倪新宇,陈美行","cat":"恐怖,惊悚,悬疑","wish":17215,"3d":false,"pn":33,"scm":"夫人突暴毙，地下藏玄机","imax":false,"snum":2067,"nm":"怨灵地下室","dur":89,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/b313dcb28fbd25fd116485ee9ada2737980656.jpeg","sc":3.3,"ver":"2D","rt":"2016-11-25上映","id":1182756,"time":""},{"late":false,"showInfo":"今天13家影院放映20场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林超贤","star":"张涵予,彭于晏,冯文娟","cat":"动作,犯罪,剧情","wish":57407,"3d":false,"pn":296,"scm":"商船藏毒品，冤屈难洗清","imax":false,"snum":821394,"nm":"湄公河行动","dur":124,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/8f8efcd7a8c3dbcbe13fe2cd855ea6a42750455.jpg","sc":9.3,"ver":"2D/中国巨幕","rt":"2016-09-30上映","id":338391,"time":""},{"late":false,"showInfo":"今天11家影院放映20场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"宫元宏彰","star":"田中真弓,大谷育江,冈村明美","cat":"动画,冒险","wish":118442,"3d":false,"pn":108,"scm":"热血海贼王，冒险新起航","imax":false,"snum":96216,"nm":"航海王之黄金城","dur":121,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/e17eb219908416b7ee3bf07c2dc295ac945415.jpg","sc":9.1,"ver":"2D","rt":"2016-11-11上映","id":344902,"time":""},{"late":false,"showInfo":"今天15家影院放映16场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"林浩然","star":"陈妍希,杰克逊·拉斯波恩,成康","cat":"剧情,爱情,悬疑","wish":11823,"3d":false,"pn":39,"scm":"只是被车撞，生活却变样","imax":false,"snum":594,"nm":"夏威夷之恋","dur":95,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/501b866b4605b4933b1ebec67bc49da74245946.jpg","sc":7.3,"ver":"2D","rt":"2016-11-25上映","id":337195,"time":""},{"late":false,"showInfo":"今天3家影院放映11场","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"张末","star":"倪妮,霍建华,马苏","cat":"喜剧,爱情,奇幻","wish":91691,"3d":false,"pn":140,"scm":"哭成小笨蛋，笑回长大前","imax":false,"snum":71,"nm":"28岁未成年","dur":109,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","sc":9.3,"ver":"2D","rt":"下周五上映","id":343413,"time":""},{"late":false,"showInfo":"今天10家影院放映15场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"周申,刘露","star":"任素汐,大力,刘帅良","cat":"剧情,喜剧","wish":29385,"3d":false,"pn":157,"scm":"谎言圆不上，人比驴荒唐","imax":false,"snum":135645,"nm":"驴得水","dur":111,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/13d4883803f25244d266c7cd3ac2f15d327618.jpg","sc":8.5,"ver":"2D","rt":"2016-10-28上映","id":410612,"time":""},{"late":false,"showInfo":"今天13家影院放映15场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"陈兵","star":"安宰贤,安以轩,方中信","cat":"剧情,爱情","wish":20845,"3d":false,"pn":70,"scm":"处女爱处男，结局并不惨","imax":false,"snum":1553,"nm":"我是处女座","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/98d1eac6f63b475e1d937c19666029c4238607.jpg","sc":7.9,"ver":"2D","rt":"2016-11-25上映","id":344437,"time":""},{"late":false,"showInfo":"2016-12-01 本周四上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"谢云鹏,杜昌博","star":"郑昊,张墨锡,王佳琦","cat":"剧情,爱情","wish":2122,"3d":false,"pn":265,"scm":"女孩遭性侵，山村来打拼","imax":false,"snum":68,"nm":"爱你的人","dur":92,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/808a19b387ec5dcbbb016513f9634a9d1415574.jpg","sc":0,"ver":"2D","rt":"本周四上映","id":345529,"time":""},{"late":false,"showInfo":"今天5家影院放映8场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"郭翔","star":"马德钟,王大治,刘力扬","cat":"剧情,喜剧,爱情","wish":3016,"3d":false,"pn":77,"scm":"不惑未婚男，追女赴越南","imax":false,"snum":246,"nm":"越囧","dur":96,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/69920759ab83d5343db11ef889946ff0107209.jpg","sc":0,"ver":"2D","rt":"2016-11-25上映","id":246674,"time":""},{"late":false,"showInfo":"今天6家影院放映7场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"安兵基","star":"佟大为,陈妍希,吕云骢","cat":"剧情,喜剧,家庭","wish":39153,"3d":false,"pn":166,"scm":"主播有点烦，儿孙太能缠","imax":false,"snum":36962,"nm":"外公芳龄38","dur":103,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/119fc2dd0b9c55001831e6fc5dd2a374115176.jpg","sc":8.3,"ver":"2D","rt":"2016-11-11上映","id":342427,"time":""},{"late":false,"showInfo":"今天4家影院放映6场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"亚瑟·本扎昆","star":"凯文·亚当斯,让-保罗·卢弗,凡妮莎·吉德","cat":"喜剧,爱情","wish":19648,"3d":false,"pn":76,"scm":"穷人爱公主，神灯来帮助","imax":false,"snum":11089,"nm":"阿拉丁与神灯","dur":101,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/2d5fb108c7868e870daa1787cee484b7697168.jpg","sc":7.4,"ver":"2D","rt":"2016-11-18上映","id":346365,"time":""},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"宁海强","star":"李东学,聂远,于小伟","cat":"历史,战争,动作","wish":10456,"3d":false,"pn":134,"scm":"夜奔百余里，行军创奇迹","imax":false,"snum":17413,"nm":"勇士","dur":102,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/487c91816e531c33063fefa657d4c6e4656569.jpeg","sc":8.8,"ver":"2D/中国巨幕","rt":"2016-10-14上映","id":346759,"time":""},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"马蒂亚斯·霍恩","star":"赵又廷,倪妮,尤赖亚·谢尔顿","cat":"动作,冒险,奇幻","wish":23294,"3d":true,"pn":212,"scm":"异世来相逢，勇者得重生","imax":false,"snum":19291,"nm":"勇士之门","dur":108,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/c3cb7d5ec4d961c793bd812805a30bc4621134.jpg","sc":6.5,"ver":"2D/3D/中国巨幕","rt":"2016-11-18上映","id":248637,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"克林特·伊斯特伍德","star":"汤姆·汉克斯,艾伦·艾克哈特,劳拉·琳妮","cat":"剧情,传记","wish":12510,"3d":false,"pn":79,"scm":"飞机遇意外，机长险被害","imax":true,"snum":194,"nm":"萨利机长","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/470b3d85956f801fdcdeaa1d1c1a5c84234487.jpg","sc":0,"ver":"2D/IMAX 2D/中国巨幕","rt":"下周五上映","id":342003,"time":""},{"late":false,"showInfo":"今天1家影院放映2场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘雨霖","star":"毛孩,李倩,刘蓓","cat":"剧情","wish":11050,"3d":false,"pn":176,"scm":"婚后无话讲，与谁诉短长","imax":false,"snum":6787,"nm":"一句顶一万句","dur":110,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/44e7bf41b8d9bf7a061b5647bb3f0fc9586345.jpg","sc":7.7,"ver":"2D","rt":"2016-11-04上映","id":345216,"time":""},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"钟萱","star":"钟萱,温兆伦,刘宇珽","cat":"恐怖,惊悚,悬疑","wish":4173,"3d":false,"pn":47,"scm":"神秘白云桥，阴阳交界处","imax":false,"snum":2364,"nm":"白云桥","dur":94,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/0b5e98a4b7044cc7e445da18c460e104373854.jpg","sc":5.9,"ver":"2D","rt":"2016-11-18上映","id":1187417,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"蒋钦民","star":"袁成杰,曹云金,江若琳","cat":"剧情,喜剧,爱情","wish":16812,"3d":false,"pn":35,"scm":"新郎要逃婚，中了大陷阱","imax":false,"snum":828,"nm":"不离不弃","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d0ccc26a636ae1a6ea4dcb7453758888675237.jpg","sc":7.3,"ver":"2D","rt":"2016-11-04上映","id":345494,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"刘杰","star":"霍建华,秦海璐,万茜","cat":"惊悚,悬疑,犯罪","wish":42092,"3d":false,"pn":153,"scm":"哥哥久失踪，符号引惶恐","imax":false,"snum":53281,"nm":"捉迷藏","dur":105,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/584a35567b3baecfe7347481ba09d9a8418043.jpg","sc":8.2,"ver":"2D","rt":"2016-11-04上映","id":346299,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"朱员成","star":"颜丙燕,王德顺,艾丽娅","cat":"剧情","wish":9000,"3d":false,"pn":55,"scm":"时光终将老，陪伴少不了","imax":false,"snum":289,"nm":"盛先生的花儿","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/447cc8fdcac0d0bcfaeca531b9f49ed2591404.jpg","sc":8.2,"ver":"2D","rt":"2016-11-04上映","id":621219,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"苑本立","star":"聂远,叶一云","cat":"剧情","wish":46,"3d":false,"pn":11,"scm":"红军开道路，迎接大部队","imax":false,"snum":54,"nm":"生死96小时","dur":97,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/e6bc541ab839d55e868948f850bc1d9c141987.jpg","sc":0,"ver":"2D","rt":"2016-11-09上映","id":1196221,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"张坚庭","star":"郑嘉颖,小小彬,李呈媛","cat":"剧情,喜剧,爱情","wish":16655,"3d":false,"pn":61,"scm":"育儿新绝招，假装被破产","imax":false,"snum":1932,"nm":"贫穷富爸爸","dur":96,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/34f14bdd361cae758f52dae3436082d1801317.jpg","sc":8.2,"ver":"2D","rt":"2016-11-10上映","id":336061,"time":""},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"崔志敏","star":"邹德江,章宇,卢倩文","cat":"剧情,战争","wish":7,"3d":false,"pn":7,"scm":"燕赵大地上，鬼子无处藏","imax":false,"snum":8,"nm":"热土悲歌","dur":90,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/04f0da4d0be4067a3a8066982ae63dfc64193.jpg","sc":0,"ver":"2D","rt":"2016-11-25上映","id":1189305,"time":""},{"late":false,"showInfo":"2016-12-02 本周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"李柯","star":"隋咏良,尤靖茹,薛祺","cat":"剧情,爱情,冒险","wish":2178,"3d":false,"pn":68,"scm":"沙漠越野赛，飙车为求爱","imax":false,"snum":15,"nm":"沙漠之心","dur":94,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/afb1ae81d7ef6a57c5abc20d9fcdd35920580551.jpg","sc":0,"ver":"2D","rt":"本周五上映","id":1197460,"time":""},{"late":false,"showInfo":"2016-12-09 下周五上映","cnms":0,"sn":0,"preSale":1,"vd":"","dir":"万玛才旦","star":"西德尼玛,杨秀措,扎西","cat":"剧情","wish":2137,"3d":false,"pn":44,"scm":"牧羊人进城，打碎纯真梦","imax":false,"snum":426,"nm":"塔洛","dur":120,"showDate":"","src":"","img":"http://p1.meituan.net/165.220/movie/edb74b337c4f3175b2a45b045619963d460760.jpg","sc":0,"ver":"2D","rt":"下周五上映","id":337708,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"孙亮","star":"吴镇宇,戴立忍,李昕芸","cat":"悬疑,剧情","wish":5709,"3d":false,"pn":88,"scm":"医生有武器，心计和身体","imax":false,"snum":1348,"nm":"判我有罪","dur":102,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/917740c10fed0a65f057c3acc14f4eab393827.jpg","sc":6.5,"ver":"2D","rt":"2016-05-06上映","id":343082,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"毕赣","star":"陈永忠,郭月,余世学","cat":"剧情,悬疑","wish":5647,"3d":false,"pn":95,"scm":"离家把侄寻，帮人带书信","imax":false,"snum":6049,"nm":"路边野餐","dur":113,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/d089ecbfb74fc1a234b7b1b8c5cadcf0516192.jpg","sc":8.1,"ver":"2D","rt":"2016-07-15上映","id":342073,"time":""},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"preSale":0,"vd":"","dir":"摩撒利","star":"殷果儿,丁汇宇,刘小奇","cat":"爱情,惊悚,悬疑","wish":17879,"3d":false,"pn":34,"scm":"东方魔幻书，怪力乱神出","imax":false,"snum":4416,"nm":"聊斋新编之画皮新娘","dur":88,"showDate":"","src":"","img":"http://p0.meituan.net/165.220/movie/dd9d76aaa8a1bdad4f2907b78efb594f95916.jpeg","sc":5,"ver":"2D","rt":"2016-11-11上映","id":346546,"time":""}]
     */

    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        private boolean hasNext;
        /**
         * late : false
         * showInfo : 今天165家影院放映2088场
         * cnms : 0
         * sn : 0
         * preSale : 0
         * vd :
         * dir : 大卫·叶茨
         * star : 埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·萨多尔
         * cat : 冒险,奇幻,家庭
         * wish : 130686
         * 3d : true
         * pn : 236
         * scm : 神奇动物城，法师显超能
         * imax : true
         * snum : 99535
         * nm : 神奇动物在哪里
         * dur : 133
         * showDate :
         * src :
         * img : http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg
         * sc : 9
         * ver : 3D/IMAX 3D/中国巨幕
         * rt : 2016-11-25上映
         * id : 248918
         * time :
         */

        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            private boolean late;
            private String showInfo;
            private int cnms;
            private int sn;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @JSONField(name = "3d")
            private boolean value3d;
            private int pn;
            private String scm;
            private boolean imax;
            private int snum;
            private String nm;
            private int dur;
            private String showDate;
            private String src;
            private String img;
            private int sc;
            private String ver;
            private String rt;
            private int id;
            private String time;

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean isValue3d() {
                return value3d;
            }

            public void setValue3d(boolean value3d) {
                this.value3d = value3d;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getSc() {
                return sc;
            }

            public void setSc(int sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }
    }
}
