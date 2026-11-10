
/**
 * This file has been completed for you. 
 * You can modify it to test your code. 
 * But you don't need to submit this file.
 */
public class PA3Table extends PA2.Table {
    public PA3Table(int numPlayers) {
        super(numPlayers);
    }
    public static void main(String[] args) {
        PA3Table table = new PA3Table(4);
        table.runApp();
    }
    @Override
    protected void createPlayer() {
        players[0] = new PA2.Player("Human player");
        for (int i = 1; i < players.length; i++) {
            if (i % 2 == 0)
                players[i] = new LazyPlayer();
            else
                players[i] = new MinPlayer(this);
        }
    }
}
