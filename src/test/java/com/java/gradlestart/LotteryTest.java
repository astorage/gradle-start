package com.java.gradlestart;

import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTest{

    private int RED_RANGE = 33;
    private int BLUE_RANGE = 16;

    private BigDecimal PRICE = new BigDecimal("2");


    private ThreadLocal<OutputStreamWriter> outputStreamWriterThreadLocal = new ThreadLocal<>();

    private BigDecimal STEP = new BigDecimal("1");

    private long ROUND = 100000;

    private ThreadLocal<Long> roundThreadLocal = ThreadLocal.withInitial(() -> 0L);

    @Test
    public void test() {
        String theResult = bet();
        System.out.println(theResult);
        //String result = "07 08 12 21 23 27 12";//2019-5-21
        String result = "04 06 08 11 30 33 11";//2019-6-11
        System.out.println(result.length() == theResult.length());
    }

    private void init(int no) {
        try {
            File file = new File("G:\\semulate\\lottery"+ no +".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            outputStreamWriterThreadLocal.set(new OutputStreamWriter(fos,"utf-8"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多线程模拟买双色球，测试需要大概多少次才能中
     */
    @Test
    public void test1(){
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            int n = j;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    init(n);
                    try {
                        semulateBet();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private void semulateBet()  throws IOException{
        //String result = "07 08 12 21 23 27 12";
        String result = "04 06 08 11 30 33 11";//2019-6-11
        BigDecimal sum = new BigDecimal("0");
        BigDecimal money;
        while (true) {
            String myBet = bet();
            sum = sum.add(STEP);
            write(sum, myBet);
            if (result.equals(myBet)) {
                break;
            }
        }
        money = sum.multiply(PRICE);
        OutputStreamWriter outputStreamWriter = outputStreamWriterThreadLocal.get();
        outputStreamWriter.write("在第"+sum.toString()+"次命中, 需花费"+ money.toString() + " 元");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    private void write(BigDecimal sum, String myBet) throws IOException {
        OutputStreamWriter outputStreamWriter = outputStreamWriterThreadLocal.get();
        outputStreamWriter.write(myBet + " : " + sum + "\r\n");
        Long round = roundThreadLocal.get();

        round ++;
        if (round == ROUND) {
            outputStreamWriter.flush();
            round = 0L;
        }
        roundThreadLocal.set(round);
    }

    private String bet() {
        return generateRedCode() + generateBlueCode();
    }

    private String generateBlueCode() {
        Long redNum = randomGenerateNum(BLUE_RANGE);
        String redCode = format(redNum);
        return redCode;
    }

    private String generateRedCode() {
        List<Long> codeList = new ArrayList<>();
        for (int i = 0; i < 6; i++ ) {
            codeList.add(randomGenerateNum(RED_RANGE));
        }
        List<Long> sortedCodeList = sort(codeList);
        List<String> formatedCodeList = format(sortedCodeList);

        StringBuilder sb = new StringBuilder();
        for (String code : formatedCodeList) {
            sb.append(code).append(" ");
        }
        return sb.toString();
    }

    private List<Long> sort(List<Long> originList) {
        return originList.stream().sorted().collect(Collectors.toList());
    }

    private String format( Long num) {
        return String.format("%02d", num);
    }


    private List<String> format(List<Long> codeList) {
        return codeList.stream().map(code -> format(code)).collect(Collectors.toList());
    }

    @Test
    public void test2 () {
        while (true) {
            System.out.println(randomGenerateNum(3));
        }
    }


    private Long randomGenerateNum(int range) {
        Double origin = Math.random();
        Long result = Math.round(Math.ceil(origin*range));
        return result;
    }

    @Test
    public void test3 () {
        for (int i = 0; i< 10 ; i++) {
            writeFile("sdfsdkfjdkfjdfkd");
        }
    }

    private void writeFile(String content) {
        try {
            File file = new File("G:\\lotter.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
//            FileWriter fw = new FileWriter(file);
//            fw.append(content);
            FileOutputStream fos = new FileOutputStream(file, true);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos,"utf-8");
            outputStreamWriter.write(content + "\r\n");
            //outputStreamWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
