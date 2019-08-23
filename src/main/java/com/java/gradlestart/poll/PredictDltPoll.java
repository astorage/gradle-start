package com.java.gradlestart.poll;

public class PredictDltPoll extends AbstractPredictPoll implements GenerateDltCode {

    /**
     * 模拟次数
     */
    private static long SEMULATE_TIME = 5;

    /**
     * 根据luckTime预测dlt选5个号
     */
    public void predict() {
        multiple(SEMULATE_TIME);
    }

}
