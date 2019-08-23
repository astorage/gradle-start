package com.java.gradlestart.poll;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPoll implements GenerateCode{


    void multiple(long semulateTime) {
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < semulateTime; j++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
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

    abstract void function() throws Exception;

    public String bet() {
        return generateRedCode() + generateBlueCode();
    }

}
