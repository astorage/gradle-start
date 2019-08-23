package com.java.gradlestart.poll;

public class BetDltOnce implements GenerateDltCode {
    /**
     * 随机生成一个dlt号码
     * @return dlt号码
     */
    @Override
    public String bet() {
        return generateRedCode() + generateBlueCode();
    }
}
