package PA2;

import java.util.concurrent.ThreadLocalRandom;


/**
 * 
 * Referring to this file, refactor your Table class in PA2 to support 
 * the new features in PA3.
 * 
 * You have to:
 * 1. Copy your original code, except your constructor into this file.
 * 2. Refactor your constructor like below
 * 
 */

public class Table {


    /**
     * The array of players, change the visibility to protected.
     * This line of code is finished. Nothing need to add/change
     */
    protected final Player[] players;

    /**
     * The constructor is refactored. No change is needed.
     * @param numOfPlayers
     */
    public Table(int numOfPlayers) {
        if (numOfPlayers < 3 || numOfPlayers > 5) {
            throw new IllegalArgumentException("Number of players must be between 3 and 5.");
        }

        NUM_OF_PLAYERS = numOfPlayers;
        players = new Player[NUM_OF_PLAYERS];

        createPlayer();

        dealCardsAndSetupStacks();

    }

    /**
     * Creates the default players.
     *
     * To use LazyPlayer or MinPlayer, override this method in PA3Table.
     * See the supplied PA3Table.java for an example.
     *
     * Do not instantiate LazyPlayer or MinPlayer directly in this class:
     * Table belongs to package PA2, while those classes are in the
     * default package.
     */
    protected void createPlayer() {
        for (int i = 0; i < NUM_OF_PLAYERS; i++) 
            players[i] = new Player(NAMES[i]);


    }
    protected void dealCardsAndSetupStacks() {
        //Your code from PA2
    }
    /**
     * get stacksCount, added for PA3
     */
    public int getStacksCount(int index) {
        return stacksCount[index];
    }

    //Add other methods and fields from your PA2 Table.

}
