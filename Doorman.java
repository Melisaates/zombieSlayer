public class Doorman extends Thread{
    ZombieCounter zc;
    public DoorMan(ZombieCounter zombieCounter) {
        this.zc=zombieCounter;
     }
    public void run () {
        double r=Math.random();
        zc.zombieEntered();
        Thread.sleep(2000);
        

    }
}
