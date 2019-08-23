package com.java.gradlestart.poll;



/**
 * dlt
 */
public abstract class AbstractPredictPoll extends AbstractPoll {

    /**
     *
     * 幸运次数 （这个数是经过100次命中，平均需要的次数）
     *
     */
    private static final int LUCK_TIME = 28749932;

    void function() {
        String lottery = "";
       for (int i = 0; i < LUCK_TIME; i++) {
           lottery  = bet();
       }
        System.out.println(Thread.currentThread() + ":" + lottery);
    }





}
