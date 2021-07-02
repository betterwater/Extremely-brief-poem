package com.example.poemdemo;

import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Poem {
    private long id;
    private String title = "";
    private String author = "";
    private String content = "";

    public Poem(long id, String author, String title, String csvContent) {
        this.id = id;
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(csvContent);
    }

    public Poem(String author, String title, String csvContent) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setContent(csvContent);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final List<Poem> getDefaultPoem() {
        List<Poem> poems = new ArrayList<>();
        poems.add(new Poem(0, "张若虚", "春江花月夜", "春江潮水连海平\n海上明月共潮生\n不知乘月几人归\n落月摇情满江树"));
        poems.add(new Poem(1, "王维", "相思", "红豆生南国\n春来发几枝\n愿君多采撷\n此物最相思\n"));
        poems.add(new Poem(2, "王维", "山中送别", "山中相送罢\n日暮掩柴扉\n春草明年绿\n王孙归不归\n"));
        poems.add(new Poem(3, "王翰", "凉州词", "葡萄美酒夜光杯\n欲饮琵琶马上催\n醉卧沙场君莫笑\n古来征战几人回\n"));
        poems.add(new Poem(4, "杜牧", "赠别", "多情却似总无情\n唯觉樽前笑不成\n蜡烛有心还惜别\n替人垂泪到天明\n"));
        poems.add(new Poem(5, "杜甫", "登高", "风急天高猿啸哀，渚清沙白鸟飞回\n无边落木萧萧下，不尽长江滚滚来\n万里悲秋常作客，百年多病独登台\n艰难苦恨繁霜鬓，潦倒新停浊酒杯\n"));
        poems.add(new Poem(6, "孟浩然", "春晓", "春眠不觉晓\n处处闻啼鸟\n夜来风雨声\n花落知多少\n"));
        poems.add(new Poem(7, "贺知章", "咏柳", "碧玉妆成一树高\n万条垂下绿丝绦\n不知细叶谁裁出\n二月春风似剪刀\n"));
        poems.add(new Poem(8, "杜甫", "春夜喜雨", "好雨知时节，当春乃发生\n随风潜入夜，润物细无声\n野径云俱黑，江船火独明\n晓看红湿处，花重锦官城\n"));
        poems.add(new Poem(9, "白居易", "大林寺桃花", "人间四月芳菲尽\n山寺桃花始盛开\n长恨春归无觅处\n不知转入此中来\n"));
        poems.add(new Poem(10, "白居易", "钱塘湖春行", "孤山寺北贾亭西，水面初平云脚低\n几处早莺争暖树，谁家新燕啄春泥\n乱花渐欲迷人眼，浅草才能没马蹄\n最爱湖东行不足，绿树阴里白沙堤\n"));
        poems.add(new Poem(11, "王安石", "元日", "爆竹声中一岁除\n春风送暖入屠苏\n千门万户曈曈日\n总把新桃换旧符\n"));
        poems.add(new Poem(12, "杨万里", "小池", "泉眼无声惜细流\n树荫照水爱晴柔\n小荷才露尖尖角\n早有蜻蜓立上头\n"));
        poems.add(new Poem(13, "杨万里", "晓出净慈寺送林子方", "毕竟西湖六月中\n风光不与四时同\n接天莲叶无穷碧\n映日荷花别样红\n"));
        poems.add(new Poem(14, "苏轼", "惠崇春江晚景二首", "竹外桃花三两枝\n春江水暖鸭先知\n蒌蒿满地芦芽短\n正是河豚欲上时\n"));
        poems.add(new Poem(15, "叶绍翁", "游园不值", "应怜屐齿印苍苔\n小扣柴扉久不开\n春色满园关不住\n一枝红杏出墙来\n"));
        poems.add(new Poem(16, "朱熹", "春日", "胜日寻芳泗水滨\n无边光景一时新\n等闲识得东风面\n万紫千红总是春\n"));
        poems.add(new Poem(17, "林升", "题临安邸", "山外青山楼外楼\n西湖歌舞几时休\n暖风熏得游人醉\n直把杭州作汴州\n"));
        poems.add(new Poem(18, "李清照", "夏日绝句", "生当做人杰\n死亦为鬼雄\n至今思顶羽\n不肯过江东\n"));
        poems.add(new Poem(19, "邵雍", "一去二三里", "一去二三里\n烟村四五家\n亭台六七座\n八九十枝花\n"));
        poems.add(new Poem(20, "白居易", "忆江南", "江南好，风景旧曾谙\n日出江花红胜火\n春来江水绿如蓝\n能不忆江南\n"));
        poems.add(new Poem(21, "李白", "早发白帝城", "朝辞白帝彩云间\n千里江陵一日还\n两岸猿声啼不住\n轻舟已过万重山\n"));
        poems.add(new Poem(22, "李白", "送孟浩然之广陵", "故人西辞黄鹤楼\n烟花三月下扬州\n孤帆远影碧空尽\n唯见长江天际流\n"));
        poems.add(new Poem(23, "李白", "望天门山", "天门中断楚江开\n碧水东流至此回\n两岸青山相对出\n孤帆一片日边来\n"));
        poems.add(new Poem(24, "李白", "独坐敬亭山", "众鸟高飞尽\n孤云独去闲\n相看两不厌\n只有敬亭山\n"));
        poems.add(new Poem(25, "杜甫", "江畔独步寻花其六", "黄寺娘家花满蹊\n千多万朵压枝低\n留连戏蝶时时舞\n自在娇莺恰恰啼\n"));
        poems.add(new Poem(26, "王维", "竹里馆", "独坐幽篁里\n弹琴复长啸\n深林人不知\n明月来相照\n"));
        poems.add(new Poem(27, "王维", "相思", "红豆生南国\n春来发几枝\n愿君多采撷\n此物最相思\n"));
        poems.add(new Poem(28, "王维", "九月九日忆山东兄弟", "独在异乡为异客\n每逢佳节倍思亲\n遥知兄弟登高处\n遍插茱萸少一人\n"));
        poems.add(new Poem(29, "杜牧", "江南春", "千里莺啼绿映红\n水村山郭酒旗风\n南朝四百八十寺\n多少楼台烟雨中\n"));
        poems.add(new Poem(30, "杜牧", "赤壁", "折戟沉沙铁未销\n自将磨洗认前朝\n东风不与周郎便\n铜雀春深锁二乔\n"));
        poems.add(new Poem(31, "王安石", "泊船瓜洲", "京口瓜洲一水间\n钟山只隔数重山\n春风又绿江南岸\n明月何时照我还\n"));
        poems.add(new Poem(32, "白居易", "赋得古原草送别", "离离原上草，一岁一枯荣\n野火烧不尽，春风吹又生\n远芳侵古道，晴翠接荒城\n又送王孙去，萋萋满别情\n"));
        poems.add(new Poem(33, "崔护", "题都城南庄", "去年今日此门中\n人面桃花相映红\n人面不知何处去\n桃花依旧笑春风\n"));
        poems.add(new Poem(34, "杜甫", "江畔独步寻花其五", "黄师塔前江水东\n春光懒困倚微风\n桃花一簇开无主\n可爱深红爱浅红\n"));
        poems.add(new Poem(35, "杜牧", "清明", "清明时节雨纷纷\n路上行人欲断魂\n借问酒家何处有\n牧童遥指杏花村\n"));
        poems.add(new Poem(36, "民歌", "敕勒歌", "敕勒川，阴山下\n天似穹庐，笼盖四野\n天苍苍，野茫茫\n风吹草低现牛羊\n"));
        poems.add(new Poem(37, "贺知章", "回乡偶书", "少小离家老大回\n乡音无改鬓毛衰\n儿童相见不相识\n笑问客从何处来\n"));
        poems.add(new Poem(38, "张继", "枫桥夜泊", "月落乌啼霜满天\n江枫渔火对愁眠\n姑苏城外寒山寺\n夜半钟声到客船\n"));
        poems.add(new Poem(39, "韦应物", "滁州西涧", "独怜幽草涧边生\n上有黄鹂深树鸣\n春潮带雨晚来急\n野渡无人舟自横\n"));
        poems.add(new Poem(40, "卢纶", "塞下曲", "林暗草惊风\n将军夜引弓\n平明寻白羽\n没在石棱中\n"));
        poems.add(new Poem(41, "陈子昂", "登幽州台歌", "前不见古人\n后不见来者\n念天地之悠悠\n独怆然而涕下\n"));
        poems.add(new Poem(42, "杜甫", "春望", "国破山河在，城春草木深\n感时花溅泪，恨别鸟惊心\n烽火连三月，家书抵万金\n白头搔更短，浑欲不胜簪\n"));
        poems.add(new Poem(43, "李白", "月下独酌", "花间一壶酒，独酌无相亲\n举杯邀明月，对影成三人\n月既不解饮，影徒随我身\n暂伴月将影，行乐须及春\n我歌月徘徊，我舞影零乱\n醒时同交欢，醉后各分散\n永结无情游，相期邈云汉\n"));
        poems.add(new Poem(44, "杜甫", "蜀相", "丞相祠堂何处寻？锦官城外柏森森\n映阶碧草自春色，隔叶黄鹂空好音\n三顾频烦天下计，两朝开济老臣心\n出师未捷身先死，长使英雄泪满襟\n"));
        poems.add(new Poem(45, "李商隐", "锦瑟", "锦瑟无端五十弦，一弦一柱思华年\n庄生晓梦迷蝴蝶，望帝春心托杜鹃\n沧海月明珠有泪，蓝田日暖玉生烟。\n此情可待成追忆，只是当时已惘然\n"));
        poems.add(new Poem(46, "李白", "行路难", "金樽清酒斗十千，玉盘珍馐直万钱\n停杯投箸不能食，拔剑四顾心茫然\n欲渡黄河冰塞川，将登太行雪暗天\n闲来垂钓坐溪上，忽复乘舟梦日边\n行路难，行路难，多歧路，今安在\n长风破浪会有时，直挂云帆济沧海\n"));
        poems.add(new Poem(47, "王昌龄", "出塞", "秦时明月汉时关\n万里长征人未还\n但使龙城飞将在\n不教胡马度阴山\n"));
        poems.add(new Poem(48, "崔颢", "黄鹤楼", "昔人已乘黄鹤去，此地空余黄鹤楼\n黄鹤一去不复返，白云千载空悠悠\n晴川历历汉阳树，芳草萋萋鹦鹉洲\n日暮乡关何处是？烟波江上使人愁\n"));
        poems.add(new Poem(49, "李白", "静夜思", "床前明月光\n疑是地上霜\n举头望明月\n低头思故乡\n"));
        poems.add(new Poem(50, "孟浩然", "春晓", "春眠不觉晓\n处处闻啼鸟\n夜来风雨声\n花落知多少\n"));
        return poems;
    }
}
