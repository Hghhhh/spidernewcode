package com.hgh.spidernewcode.inferface.impl;

import com.hgh.spidernewcode.inferface.ProcessStrategy;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 利用装饰者模式装装饰爬取单个文章的策略类,使process可以迭代更多路径爬取
 *
 * 这样做的好处就是，扩展性非常的良好。每一层都只关心这一层的逻辑，只要这一层的实现完毕，就不用再操心这一层的逻辑了。
 */
public class IteratorProcessorStrtegy extends FilterProcessStrategy {
    public IteratorProcessorStrtegy(ProcessStrategy processStrategy) {
        super(processStrategy);
    }
    public IteratorProcessorStrtegy() {
        //默认爬取牛课网讨论区
        super(new NewCodeArticleProcessStrategy());
    }


    @Override
    public void doProcess(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://www\\.nowcoder\\.com/discuss/[0-9]+)").all());
        processStrategy.doProcess(page);
    }

}
