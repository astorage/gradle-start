package com.java.gradlestart;

import com.java.gradlestart.poll.PredictDltPoll;
import com.java.gradlestart.poll.PredictSsqPoll;
import org.junit.Test;

public class PollTest {

    @Test
    public void testDltPoll() {
        PredictDltPoll predictDltPoll = new PredictDltPoll();
        predictDltPoll.predict();
    }


    @Test
    public void testSsqPoll() {
        PredictSsqPoll predictSsqPoll = new PredictSsqPoll();
        predictSsqPoll.predict();
    }

    @Test
    public void testSUM() {
        int t1 = 1509225;
        int t2 = 12452840;
        int t3 = 8441159;
        int t4 = 9618776;
        int t5 = 26154762;
        int t6 = 39273664;
        int t7 = 35520922;
        int t8 = 41316157;
        int t9 = 36276590;
        int t10 = 71200753;

        System.out.println( (t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10)/10);

    }
}
