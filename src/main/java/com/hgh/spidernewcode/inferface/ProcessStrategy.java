package com.hgh.spidernewcode.inferface;

import us.codecraft.webmagic.Page;

/**
 * 策略模式Process总接口
 */
public interface ProcessStrategy {


    /**
     * 爬虫具体执行的方法 {@link Page}
     */
    void doProcess(Page page);

}
