package com.java.gradlestart.poll;


public class SemulateDltPoll extends AbstractSemulatePoll implements GenerateDltCode {

    private static final int SEMULATE_TIME = 100;

    /**
     * dlt模拟100次选号，命中的论述取平均值，作为luckTime。
     */
    public void computeLuckTime(String goal) {
        multiple(SEMULATE_TIME);
        setGoal(goal);
        long allSum = getAllSum().get();
        System.out.println("平均数：" + allSum / SEMULATE_TIME);
    }

}
