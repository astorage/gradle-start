package com.java.gradlestart.poll;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractSemulatePoll extends AbstractPoll {



    private BigDecimal STEP = new BigDecimal("1");

    private AtomicLong allSum = new AtomicLong();

    private String goal = "04 06 08 11 30 33 11";//2019-6-11




    void function(){
        BigDecimal sum = new BigDecimal("0");
        while (true) {
            String myBet = bet();
            sum = sum.add(STEP);
            allSum.incrementAndGet();
            if (goal.equals(myBet)) {
                break;
            }
        }
        System.out.println("在第"+sum.toString()+"次命中");
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public AtomicLong getAllSum() {
        return allSum;
    }

    public void setAllSum(AtomicLong allSum) {
        this.allSum = allSum;
    }

}
