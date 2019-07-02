package com.hgh.spidernewcode.service.pipeline;

import com.hgh.spidernewcode.inferface.impl.Observable;
import com.hgh.spidernewcode.inferface.impl.Observer;
import com.hgh.spidernewcode.model.Article;
import com.hgh.spidernewcode.util.EmailUtil;

import java.util.ArrayList;
import java.util.List;

public class MyObserver implements Observer {
    public static List<Article> articleList = new ArrayList<>();
    @Override
    public void update(Observable o, Object arg) {
        synchronized (articleList){
            articleList.add((Article) arg);
            if(articleList.size()>20){
                StringBuilder stringBuilder = new StringBuilder();
                for(Article  article :articleList){
                    stringBuilder.append(article.getTitle()+"\n");
                    stringBuilder.append(article.getPublishTime()+"\n");
                    stringBuilder.append(article.getContent()+"\n\n\n");
                }
                try {
                    EmailUtil.sendEmail(stringBuilder.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                articleList.clear();
            }
        }
    }

}
