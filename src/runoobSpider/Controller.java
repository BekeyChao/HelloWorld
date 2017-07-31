package runoobSpider;

import us.codecraft.webmagic.Spider;

/**
 * 爬虫控制器,main方法入口
 * Created by bekey on 2017/6/6.
 */
public class Controller {
    public static void main(String[] args) {
//        String url = "http://www.runoob.com/regexp/regexp-tutorial.html";
        //测试通过2017/7/31
        String url = "http://www.runoob.com/regexp/regexp-tutorial.html";
        Spider.create(new RunoobPageProcessor()).addUrl(url).addPipeline(new MarkdownSavePipeline()).thread(1).run();
    }
}
