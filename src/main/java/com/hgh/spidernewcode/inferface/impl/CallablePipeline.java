package com.hgh.spidernewcode.inferface.impl;


import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Pipeline一般直接输出到文件、数据库、控制台比较方便。但是输出到一个对象没有返回结果。 此接口扩展自 {@link Pipeline}，用来获取一个结果
 */
public interface CallablePipeline extends Observable,Pipeline {

}
