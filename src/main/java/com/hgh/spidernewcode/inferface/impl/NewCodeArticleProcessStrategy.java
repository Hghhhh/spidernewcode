package com.hgh.spidernewcode.inferface.impl;


import com.hgh.spidernewcode.inferface.ProcessStrategy;
import com.hgh.spidernewcode.model.Article;
import us.codecraft.webmagic.Page;
/**
 * 爬取牛课网讨论区单个文章的一个策略
 */
public class NewCodeArticleProcessStrategy implements ProcessStrategy {

    @Override
    public void doProcess(Page page) {
        //page.addTargetRequests(page.getHtml().links().regex("(https://www\\.nowcoder\\.com/discuss/[\\w\\-]+)").all());
        page.putField("articleId", page.getUrl().regex("https://www\\.nowcoder\\.com/discuss/(\\w+)").toString());
        if (page.getResultItems().get("articleId")==null){
            //skip this page
            page.setSkip(true);
        }
        Article article = new Article();
        article.setTitle(page.getHtml().xpath("//span[@class='crumbs-end']/text()").toString());
        article.setContent(page.getHtml().xpath("//div[@class=post-topic-main]").toString());
        article.setAuthor(page.getHtml().xpath("//div[@class='post-detail']/span/a/text()").toString());
        article.setPublishTime(page.getHtml().xpath("//span[@class='post-time']/text()").toString());
        article.setArticleId(page.getUrl().regex("https://www\\.nowcoder\\.com/discuss/(\\w+)").toString());
       // page.putField("author",page.getHtml().xpath("//div[@class='post-detail']/span/a/text()"));
      //  page.putField("title", page.getHtml().xpath("//span[@class='crumbs-end']/text()").toString());
       // page.putField("publishTime", page.getHtml().xpath("//span[@class='post-time']/text()").toString());
        //page.putField("content",page.getHtml().xpath("//div[@class=post-topic-main]").toString());
        page.putField("article",article);
    }
}
