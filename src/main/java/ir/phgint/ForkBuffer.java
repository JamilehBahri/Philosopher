package ir.phgint;

/**
 * Created by Jamile on 8/10/2017.
 */
public class ForkBuffer {

    public   int maxFork;
    private  int count;

    public ForkBuffer(int maxFork) {
        this.maxFork = maxFork;
    }


    public synchronized boolean acquireFork() {
        if(count < maxFork) {
            count++;
            return true;
        }

        return false;
    }

    public synchronized boolean releaseFork() {
        if(count > 0) {
            count --;
            return true;
        }
        return false;
    }

}