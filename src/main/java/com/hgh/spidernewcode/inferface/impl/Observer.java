package com.hgh.spidernewcode.inferface.impl;

public interface Observer {
    //观察者被通知的方法
    void update(Observable o, Object arg);
}
