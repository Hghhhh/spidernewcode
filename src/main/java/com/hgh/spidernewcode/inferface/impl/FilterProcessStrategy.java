package com.hgh.spidernewcode.inferface.impl;

import com.hgh.spidernewcode.inferface.ProcessStrategy;
import us.codecraft.webmagic.Page;

/**
 *FilterProcessor 是ProcessStrategy的装饰类，用来扩展ProcessStrategy的爬虫方法。
 * 这是一个伪实现类，真正的装饰类需要继承这个类。
 * 设计参考 {@link java.io.FilterInputStream}
 */
public class FilterProcessStrategy implements ProcessStrategy{
    protected volatile ProcessStrategy processStrategy;

    public FilterProcessStrategy(ProcessStrategy processStrategy){
        this.processStrategy = processStrategy;
    }

    @Override
    public void doProcess(Page page) {
        processStrategy.doProcess(page);
    }
}
