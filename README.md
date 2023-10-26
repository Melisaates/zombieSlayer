# zombieSlayer

## Learning Objectives:
- Concurrency

This project focuses on creating a simulation using multiple threads to clear a zombie invasion. You find yourself with just one weapon, trying to secure a room with multiple doors leading to the street, and you have a few friends with you.

Zombies are generally easy to manage as they move slowly. Each of your friends is responsible for guarding one door, allowing individual zombies to enter and keeping track of the number of incoming zombies. Meanwhile, you stand in the center of the room, trying to eliminate the zombies that have entered and counting the ones you've killed.

Clearly, you don't want too many zombies. If there are more than 100 zombies in the room at any given time, you'll die. If you manage to kill 100 zombies, you'll be safe. The only way to achieve this goal is to find a room with a sufficient number of doors leading to the street.

The project's purpose is to write code to find the maximum number of doors you can have to kill 100 zombies before you die.

## Used Classes:

### ZombieCounter:
This class has methods to keep track of the number of zombies in the room and the number of zombies killed. It includes the following methods:
- zombieEntered(): Keeps track of the number of zombies entering the room.
- zombieKilled(): Tracks the number of zombies killed.
- tooManyZombiesInTheRoom(): Returns true if there are 100 or more zombies in the room.
- killed100Zombies(): Returns true if more than 100 zombies have been killed.
- zombiesExist(): Returns true if there is at least one zombie in the room.
- getKilledCount(): Returns the number of zombies killed.
- getInTheRoomCount(): Returns the number of zombies in the room.

### DoorMan:
This class should have a ZombieCounter object to track the number of zombies. It has a constructor as follows:
public DoorMan(ZombieCounter zombieCounter) { }


Each DoorMan thread lets a zombie in every 2ms (by calling the relevant method from ZombieCounter) and keeps track of the accepted zombie count. The DoorMan thread terminates when there are too many zombies in the room (more than 100) or when Slayer has killed more than 100 zombies.

********************

### Slayer:

- This class should also have a ZombieCounter object to track the number of zombies. It has a constructor as follows:


  public Slayer(ZombieCounter zombieCounter) { }
The Slayer kills a zombie every 2ms (but must first check if there is a zombie) and keeps track of the number of zombies killed (by calling the relevant method from the ZombieCounter). The Slayer thread terminates when there are too many zombies in the room (more than 100) or when more than 100 zombies have been killed.

********************

### Simulator:

- This class provides the main management of the project. The main method creates and starts n DoorMan threads (where n is taken as a command-line argument) and one Slayer thread. When all threads finish their work, the main thread checks whether 100 zombies have been killed or if the zombies have killed you, and prints the result to the screen.
