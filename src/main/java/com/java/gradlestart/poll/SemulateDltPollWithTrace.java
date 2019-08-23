package com.java.gradlestart.poll;


public class SemulateDltPollWithTrace extends AbstractSemulatePollWithTrace implements GenerateDltCode {

    private static final int SEMULATE_TIME = 5;
    /**
     * dlt，根据目标号goal，模拟选5次，并将选号过程记录在文件中。这里面用了ThreadLoacl
     */
    public void semulatePoll(String goal) {
        multiple(SEMULATE_TIME);
        setGoal(goal);
    }

}
