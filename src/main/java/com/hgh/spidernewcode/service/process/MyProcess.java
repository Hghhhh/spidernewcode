package com.hgh.spidernewcode.service.process;

import com.hgh.spidernewcode.inferface.ProcessStrategy;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 策略模式上下文，使用策略进行爬取
 */
public class MyProcess implements PageProcessor {

    /**
     * 如果访问超时，等两分钟
     */
    private static int ONE_MINUTES = 1000 * 60;

    private static int ONE_SECOUND = 1000;

    //重试三次，等待1秒
    private Site site = Site.me().setRetryTimes(3).setSleepTime(2 * ONE_SECOUND).setRetrySleepTime(2 * ONE_MINUTES);

    /**
     * 真正实施的爬虫策略
     */
    protected ProcessStrategy processStrategy;

    /**
     * 用来修改策略，需要手动设置。不然就会抛出异常。
     */
    public void setProcessStrategy(ProcessStrategy processStrategy) {
        this.processStrategy = processStrategy;
    }


    @Override
    public void process(Page page) {
        if(processStrategy == null)
            throw new NullPointerException();
        preProcess(page);
        processStrategy.doProcess(page);
        afterProcess(page);
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     * 下面两个方法用于扩展自定义的process方法，比如加入迭代url等等。主体逻辑建议放在processStrategy中
     */
    protected void preProcess(Page page) {
    }

    protected void afterProcess(Page page) {
    }
}
