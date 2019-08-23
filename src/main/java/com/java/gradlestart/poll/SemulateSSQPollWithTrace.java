package com.java.gradlestart.poll;


public class SemulateSSQPollWithTrace extends AbstractSemulatePollWithTrace implements GenerateSsqCode {

    private static final int SEMULATE_TIME = 5;
    /**
     * ssq，根据目标号goal，模拟选5次，并将选号过程记录在文件中。这里面用了ThreadLoacl
     */
    public void semulatePoll(String goal) {
        multiple(SEMULATE_TIME);
        setGoal(goal);
    }

}
