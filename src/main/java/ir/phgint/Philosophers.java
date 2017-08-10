package ir.phgint;


public class Philosophers extends Thread {

    private final ForkBuffer fb;
    private final int id;
    private boolean isRunning = true;

    public Philosophers(ForkBuffer fb, int id) {
        this.fb = fb;
        this.id = id;
    }

    public void run() {

        while (isRunning) {
            if(fb.acquireFork()) {
                System.out.println("[Philosophers - " + id + " ] => acquire first fork . . . ");
                if(fb.acquireFork()) {
                    System.out.println("[Philosophers - " + id + " ] => acquire second fork . . . ");
                    eating();
                    fb.releaseFork();
                    fb.releaseFork();
                }

                else
                    fb.releaseFork();
            }

            thinking();
        }
    }

    private void thinking() {
        try {
            System.out.println("[Philosophers - " + id + " ] => thinking . . . ");
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eating() {
        try {
            System.out.println("[Philosophers - " + id + " ] => eating . . . ");
            sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
