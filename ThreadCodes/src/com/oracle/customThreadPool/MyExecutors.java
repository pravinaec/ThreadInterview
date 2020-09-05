/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.customThreadPool;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Pravin Singh
 */

interface MyExecutorService {
    void execute(Runnable r);
}

class MyThreadPool implements MyExecutorService {
    static int capacity;
    static int currentCapacity;
    static LinkedBlockingQueue<Runnable> linkedTaskBlockingQueue;
    Execution e;

    public MyThreadPool(int capacity) {
        this.capacity = capacity;
        currentCapacity = 0;
        linkedTaskBlockingQueue = new LinkedBlockingQueue<Runnable>();
        e = new Execution();
    }

    @Override
    public void execute(Runnable r) {
        linkedTaskBlockingQueue.add(r);
        e.executeMyMethod();
    }
}

class Execution implements Runnable {
    void executeMyMethod() {
        if (MyThreadPool.currentCapacity < MyThreadPool.capacity) {
            MyThreadPool.currentCapacity++;
            Thread t = new Thread(new Execution());
            t.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (MyThreadPool.linkedTaskBlockingQueue.size() != 0) {
                MyThreadPool.linkedTaskBlockingQueue.poll().run();
            }
        }
    }
}

public class MyExecutors {
    int capacity;

    static MyExecutorService myNewFixedThreadPool(int capacity) {
        return new MyThreadPool(capacity);
    }
}

