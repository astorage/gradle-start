package com.java.gradlestart.poll;

public class BetSsqOnce implements GenerateSsqCode {
    /**
     * 随机生成一个ssq号码
     * @return ssq号码
     */
    @Override
    public String bet() {
        return generateRedCode() + generateBlueCode();
    }
}
