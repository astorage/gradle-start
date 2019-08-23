package com.java.gradlestart.poll;

import com.java.gradlestart.constant.LotteryConstant;
import com.java.gradlestart.util.PollUtil;

public interface GenerateCode {

    String bet();

    default String generateBlueCode() {
        return PollUtil.generateCode(LotteryConstant.DLT_BLUE_RANGE, LotteryConstant.DLT_BLUE_NUM);
    }

    default String generateRedCode() {
        return PollUtil.generateCode(LotteryConstant.DLT_RED_RANGE, LotteryConstant.DLT_RED_NUM);
    }
}
