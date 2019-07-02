package com.hgh.spidernewcode.inferface.impl;

/**
 * java.util.Observable 不是一个好的设计。如果需要拥有Observable功能而去
 * 继承一个类的话，代价太沉重。我重新设计的接口，留给具体的类去实现。
 */
public interface Observable {
    //增加一个观察者
    void addObserver(Observer o);
    //删除一个观察者
    void deleteObserver(Observer o);
    //通知我们所有的观察者
    void notifyObservers(Object arg);
}
