import PA2.Card;
import PA2.Table;

import java.util.ArrayList;
import java.util.List;

//Submit this file
public class MinPlayer extends LazyPlayer {
    /**
     * 
     * 
     * Apply the following strategy using the table state when playCard()
     * is called. You do not need to predict other players' cards or later
     * changes to the stacks. This strategy does not guarantee that the
     * player will avoid collecting cards.
     * 
     * 
     * The strategy of this computer is to avoid taking cards.
     * 1. Amount all possible options, set the lowest priority to the 
     *    card which will be placed on a stack with five cards.
     * 2. Amount all possible options, set the second lowest priority 
     *   to the card that is smaller than the top cards of all stacks.
     * 3. Among the remaining options, pick the card with the smallest
     *    value.
     * 3.1 If there is no remaining option, pick the smallest card in 
     *    the set of second lowest priority.
     * 3.2 If there is no remaining option, pick the largest card in
     *   the set of lowest priority.
     * 
     * For example, if the hand has 10, 20, 30, 40. The stacks are:
     * -------------------------
     * | 0 | 1 2 3 4 14  -- -- |
     * | 1 | 5 15 25 35  -- -- |
     * | 2 | 6 16 26 36 37  -- |
     * | 3 | 7 17 27  -- -- -- |
     * -------------------------
     * 
     * Then, 20 and 40 will be in the lowest priority. 10 will be in the 
     * second lowest priority. 30 will be the only remaining option.
     * 
     * In this scenario, the card 30 will be played.
     *
     * Another example, for the same stack while the hand has 9, 10, 20, 40.
     * The lowest priority will be 20 and 40. The second lowest priority will be 9 and 10.
     * In this scenario, the card 9 (rule 3.1) will be played.
     * 
     * If the hand has only 20 and 40, then the card 40 (rule 3.2) will be played.
     *
     * Don't forget at the end you will need to remove your played card from your hand.
     *
     */


    /**
     * For stack selection, please refer to the readme file.
     */

    //TODO
}
