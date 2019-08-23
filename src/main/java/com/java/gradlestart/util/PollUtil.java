package com.java.gradlestart.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PollUtil {

    private static List<Long> sort(List<Long> originList) {
        return originList.stream().sorted().collect(Collectors.toList());
    }

    public static String generateCode(int rang, int num) {
        List<Long> codeList = new ArrayList<>();
        for (int i = 0; i < num; i++ ) {
            codeList.add(randomGenerateNum(rang));
        }
        List<Long> sortedCodeList = sort(codeList);
        List<String> formatedCodeList = format(sortedCodeList);

        StringBuilder sb = new StringBuilder();
        for (String code : formatedCodeList) {
            sb.append(code).append(" ");
        }
        return sb.toString();
    }

    private static String format( Long num) {
        return String.format("%02d", num);
    }


    private static List<String> format(List<Long> codeList) {
        return codeList.stream().map(code -> format(code)).collect(Collectors.toList());
    }



    private static Long randomGenerateNum(int range) {
        Double origin = Math.random();
        Long result = Math.round(Math.ceil(origin*range));
        return result;
    }
}
