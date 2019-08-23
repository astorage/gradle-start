package com.java.gradlestart;

import com.java.gradlestart.poll.BetSsqOnce;
import com.java.gradlestart.poll.SemulateSSQPollWithTrace;
import org.junit.Test;


public class LotterySsqTest {

    @Test
    public void test() {
        BetSsqOnce betSsqOnce = new BetSsqOnce();

        String theResult = betSsqOnce.bet();
        System.out.println(theResult);
        //String result = "07 08 12 21 23 27 12";//2019-5-21
        String result = "04 06 08 11 30 33 11";//2019-6-11
        System.out.println(result.length() == theResult.length());
    }

    /**
     * 多线程模拟买ssq，测试需要大概多少次才能中
     */
    @Test
    public void test1(){
        String goal = "04 06 08 11 30 33 11";
        SemulateSSQPollWithTrace sspwt = new SemulateSSQPollWithTrace();
        sspwt.semulatePoll(goal);
    }





}
