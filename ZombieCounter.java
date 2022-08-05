public class ZombieCounter {
    private int count = 0;//zombie sayisi
    private int killed = 0;

    /**
     * Keeps track of number of zombies entered.
     */
    void zombieEntered() {
        count++;

    }

    /**
     * Keeps track of number of zombies killed.
     */
    void zombieKilled() {
        count--;
        killed++;
        

    }

    /**
     * Returns true if the number of zombies in the room are greater than or equal
     * to 100.
     */
    boolean tooManyZombiesInTheRoom() {
        if(count > 100) return true;

        return false;

    }

    /**
     * Returns true if more than 100 zombies have been killed.
     */
    boolean killed100Zombies() {
        if(killed > 100) return true;

        return false;

    }

    /**
     * Returns true if there is at least one zombie in the room.
     */
    boolean zombiesExist() {
        return count > 0;

    }

    /**
     * Returns the count of the number of zombies killed.
     */
    int getKilledCount() {
        return killed;

    }

    /**
     * Returns the count of the number of zombies in the room.
     */
    int getInTheRoomCount() {
        return count;

    }

}
