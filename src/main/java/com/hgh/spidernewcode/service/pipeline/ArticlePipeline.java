package com.hgh.spidernewcode.service.pipeline;

import com.hgh.spidernewcode.inferface.impl.CallablePipeline;

import com.hgh.spidernewcode.inferface.impl.Observer;
import com.hgh.spidernewcode.model.Article;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


/**
 * 关于Pipeline，一个PageProcessor被执行更新一遍所有的Pipeline 如果Page被skip掉了，则不执行Pipeline
 */
public class ArticlePipeline implements CallablePipeline {

    public ArticlePipeline() {
        obs = new Vector<>();
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Article article = resultItems.get("article");
        if(!isQualifier(article)){
            throw new NullPointerException("爬取结果不全");
        }else{
            notifyObservers(article);
        }

    }

    /**
     * 该方法决定得到的结果是否合格，如果不合格抛出 {@link NullPointerException} 可以修改isQualifier判定方法 考虑到爬虫的不确定性，该条件尽可能的宽松
     */
    protected boolean isQualifier(Article article) throws NullPointerException{
        return StringUtils.isNoneEmpty(
                article.getArticleId(),article.getPublishTime(),article.getContent(),article.getAuthor()
        );
    }
    /*--  implements Observable  --*/
    private Vector<Observer> obs;

    @Override
    public synchronized void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        obs.removeElement(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        Object[] arrLocal;

        synchronized (this) {
            arrLocal = obs.toArray();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((Observer) arrLocal[i]).update(this, arg);
        }
    }

}
