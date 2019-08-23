package com.java.gradlestart.poll;

import com.java.gradlestart.constant.LotteryConstant;
import com.java.gradlestart.util.PollUtil;

public interface GenerateSsqCode extends GenerateCode {

    default String generateBlueCode() {
        return PollUtil.generateCode(LotteryConstant.SSQ_BLUE_RANGE, LotteryConstant.SSQ_BLUE_NUM);
    }

    default String generateRedCode() {
        return PollUtil.generateCode(LotteryConstant.SSQ_RED_RANGE, LotteryConstant.SSQ_RED_NUM);
    }
}
