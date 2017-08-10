package ir.phgint;


public class Philosophers extends Thread {

    private final ForkBuffer fb;
    private final int id;
    private boolean isRunning = true;


    public Philosophers(ForkBuffer fb, int id) {
        this.fb = fb;
        this.id = id;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {

        while (isRunning) {
            if(fb.acquireFork(id)) {
                System.out.println("[Philosophers - " + id + " ] => acquire  Right fork " + id);
                if(fb.acquireFork((id+1)%fb.maxFork)) {
                    System.out.println("[Philosophers - " + id + " ] => acquire  left  fork : " +  (id+1)%fb.maxFork);
                    eating();
                    fb.releaseFork(id);
                    System.out.println("[Philosophers - " + id + " ] =>   release Right fork" + id);
                    fb.releaseFork((id + 1) % fb.maxFork);
                    System.out.println("[Philosophers - " + id + " ] => release  left  fork : " + (id + 1) % fb.maxFork);

                }

                else
                    fb.releaseFork(id);
                    System.out.println("[Philosophers - " + id + " ] => release  right  fork : " + id);

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
