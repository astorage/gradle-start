package com.java.gradlestart.poll;


public class PredictSsqPoll extends AbstractPredictPoll implements GenerateSsqCode {

    /**
     * 模拟次数
     */
    private static long SEMULATE_TIME = 5;

    /**
     * 根据luckTime预测ssq选5个号
     */
    public void predict() {
        multiple(SEMULATE_TIME);
    }

}
