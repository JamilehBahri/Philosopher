package ir.phgint;

import org.junit.Test;

public class TestPhilosophers {

    @Test
    public void testPhilosopher()
    {

        Philosophers[] philosophersList = new Philosophers[5];
        ForkBuffer fb = new ForkBuffer(5);

        for (int i = 0; i <fb.maxFork ; i++) {

            philosophersList[i] = new Philosophers(fb, i);
            philosophersList[i].start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}
