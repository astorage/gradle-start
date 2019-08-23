package com.java.gradlestart.poll;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class AbstractSemulatePollWithTrace extends AbstractPoll {

    private ThreadLocal<OutputStreamWriter> outputStreamWriterThreadLocal = new ThreadLocal<>();

    private BigDecimal STEP = new BigDecimal("1");

    private long ROUND = 100000;

    private ThreadLocal<Long> roundThreadLocal = ThreadLocal.withInitial(() -> 0L);

    private BigDecimal PRICE = new BigDecimal("2");

    private String goal = "04 06 08 11 30 33 11";//2019-6-11

    private static final long MAX_SELUATE_TIME = 5;

    private void init(int no) {
        try {
            File file = new File("\\semulate\\lottery"+ no +".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            outputStreamWriterThreadLocal.set(new OutputStreamWriter(fos,"utf-8"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    void multiple(long semulateTime) {
        List<Thread> threads = new ArrayList<>();
        semulateTime = formatSemulateTime(semulateTime);
        for (int j = 0; j < semulateTime; j++) {
            int n = j;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    init(n);
                    try {
                        function();
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

    private long formatSemulateTime(long semulateTime) {
        if (semulateTime > MAX_SELUATE_TIME) {
            semulateTime = MAX_SELUATE_TIME;
        }
        else if (semulateTime < 0){
            semulateTime = 1;
        }

        return semulateTime;
    }


    void function()throws IOException{
        BigDecimal sum = new BigDecimal("0");
        BigDecimal money;
        while (true) {
            String myBet = bet();
            sum = sum.add(STEP);
            write(sum, myBet);
            if (goal.equals(myBet)) {
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


    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
