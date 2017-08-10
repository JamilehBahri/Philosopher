package ir.phgint;

public class ForkBuffer {

    public   int maxFork;
    private   final  boolean ACQUIRE_FORK = false ;
    private   final  boolean RELEASE_FORK = true ;
    private  boolean fork [] = new boolean[]{RELEASE_FORK,RELEASE_FORK,RELEASE_FORK,RELEASE_FORK,RELEASE_FORK};


    public ForkBuffer(int maxFork) {
        this.maxFork = maxFork;
    }

    public synchronized boolean acquireFork(int i) {
        if(fork[i] == RELEASE_FORK) {
           fork[i] = ACQUIRE_FORK;
            return true;
        }

        return false;
    }

    public synchronized boolean releaseFork(int i) {
        if(fork[i] == ACQUIRE_FORK) {
            fork[i] = RELEASE_FORK;
            return true;
        }
        return false;
    }

}
