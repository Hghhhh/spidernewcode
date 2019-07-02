package com.hgh.spidernewcode.service;

import com.hgh.spidernewcode.inferface.impl.IteratorProcessorStrtegy;
import com.hgh.spidernewcode.service.pipeline.ArticlePipeline;
import com.hgh.spidernewcode.service.pipeline.MyObserver;
import com.hgh.spidernewcode.service.process.MyProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;


public class SpiderService{
    private MyProcess process = new MyProcess();

    private ArticlePipeline pipeline = new ArticlePipeline();

    public void getLotsOfArticle(String beginUrl) {
        try {
          pipeline.addObserver(new MyObserver());
          //  pipeline.addObserver(new ObserverB());
            process.setProcessStrategy(new IteratorProcessorStrtegy());
            Spider.create(process)
                    .addUrl(beginUrl)
                    .addPipeline(pipeline)
                    .thread(10)
                    .run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
