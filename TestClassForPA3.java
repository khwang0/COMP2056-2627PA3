import PA2.Card;
import PA2.Player;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This file is used for testing your code. You can ignore the entire file during your development
 * You can click the button next to TestClass to test your code.
 *
 * This is also how we are going to grade your work! Of course, there will be more test cases
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClassForPA3 {
    private static ByteArrayOutputStream out;
    @BeforeAll
    public static void setup() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }



    @Test
    void testGetScore() {
        Player p = new LazyPlayer();
        p.moveToPile( new Card[] {new Card(10)} , 1);
        assertEquals(3, p.getScore());
    }



    @Test
    void testDealCard2() {
        Player p = new LazyPlayer();
        p.dealCard(new Card(4));
        p.dealCard(new Card(7));
        p.dealCard(new Card(5));

        assertEquals(4, p.getHandCard(0).getNumber());
        assertEquals(5, p.getHandCard(1).getNumber());
        assertEquals(7, p.getHandCard(2).getNumber());
    }

    @Test
    void testTakeCard() throws Exception {
        Player p = new LazyPlayer();
        Card[] cards = {new Card(4), new Card(6), new Card(8), null, null, null};
        p.moveToPile(cards, 3);
        assertNull(cards[0], "Collected card must be removed from the stack");
        assertNull(cards[1], "Collected card must be removed from the stack");
        assertNull(cards[2], "Collected card must be removed from the stack");
        assertEquals(3, p.getScore());

        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try (PrintStream captureStream = new PrintStream(captured)) {
            try {
                System.setOut(captureStream);
                p.printPile();
                captureStream.flush();
            } finally {
                System.setOut(originalOut);
            }
        }

        String pile = captured.toString().trim();
        assertTrue(pile.contains("4(1)"));
        assertTrue(pile.contains("6(1)"));
        assertTrue(pile.contains("8(1)"));
        assertEquals(12, pile.length());
    }

    @Order(1)
    @Test
    void testLazyPlayerName() {
        LazyPlayer lazyPlayer1 = new LazyPlayer();
        LazyPlayer lazyPlayer2 = new LazyPlayer();
        assertEquals("Lazy Player 1", lazyPlayer1.getName());
        assertEquals("Lazy Player 2", lazyPlayer2.getName());
    }


    @Test
    void testHandAndPileAreList() {
        Player player = new Player("Test Player");

        // Use reflection to access private fields
        try {
            // Access the 'hand' field
            Field handField = Player.class.getDeclaredField("hand");
            handField.setAccessible(true);
            Object hand = handField.get(player);
            assertTrue(hand instanceof java.util.List, "Hand should be a List");

            // Access the 'pile' field
            Field pileField = Player.class.getDeclaredField("pile");
            pileField.setAccessible(true);
            Object pile = pileField.get(player);
            assertTrue(pile instanceof java.util.List, "Pile should be a List");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testPlayCard() {
        LazyPlayer lazyPlayer = new LazyPlayer();

        // Deal cards to the player's hand
        lazyPlayer.dealCard(new Card(3));
        lazyPlayer.dealCard(new Card(5));
        lazyPlayer.dealCard(new Card(7));

        Card playedCard = lazyPlayer.playCard();

        // Verify the played card is correct
        assertNotNull(playedCard, "Played card should not be null");
        assertEquals(3, playedCard.getNumber(), "Always play the first card in the hand (smallest card)");



        assertEquals(5, lazyPlayer.getHandCard(0).getNumber(), "First card should now be 5");
        assertEquals(7, lazyPlayer.getHandCard(1).getNumber(), "Second card should now be 7");
        assertNull(lazyPlayer.getHandCard(2), "Third card should be null after playing the first card");
    }
}
