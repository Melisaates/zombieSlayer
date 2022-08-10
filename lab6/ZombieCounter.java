/**Melisa Ateş
 * atesmel12@gmail.com
 */
public class ZombieCounter {
    private int count =0;
    private int killed=0;
    /**
     * Keeps track of number of zombies entered.
     */
    synchronized void zombieEntered() {
        count++;

    }

    /**
     * Keeps track of number of zombies killed.
     */
    synchronized void zombieKilled() {
        count--;
        killed++;

    }

    /**
     * Returns true if the number of zombies in the room are greater than or equal
     * to 100.
     */
    synchronized boolean tooManyZombiesInTheRoom() {
        if(count>100) return true;

        return false;

    }

    /**
     * Returns true if more than 100 zombies have been killed.
     */
    synchronized boolean killed100Zombies() {
        if(killed>100) return true;

        return false;

    }

    /**
     * Returns true if there is at least one zombie in the room.
     */
    synchronized boolean zombiesExist() {
        return count>0;

    }

    /**
     * Returns the count of the number of zombies killed.
     */
    synchronized int getKilledCount() {
        return killed;

    }

    /**
     * Returns the count of the number of zombies in the room.
     */
     synchronized int getInTheRoomCount() {
        return count;

    }
}
