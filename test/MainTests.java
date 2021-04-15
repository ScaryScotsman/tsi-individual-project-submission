
import org.junit.jupiter.api.Test;
import uk.co.submission.CommonMethods;
import uk.co.submission.Main;
import java.util.List;
import uk.co.submission.Player;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTests{
    public static final int testNoOfPlayers = 2;
    public static final int testCardDeckSize = 56;
    public static final int testCardDeckSizeAfterRemovalOfQueen = 53;

    @Test
    void generateCardDeckSizeTest(){
        assertEquals(testCardDeckSize, Main.generateDeck().size());
    }

    @Test
    void playerToStringTest(){
        List testHand = new ArrayList();
        testHand.add("H6");
        testHand.add("D8");
        testHand.add("DQ");

        Player humanPlayer = new Player("Bishop");
        humanPlayer.setHand(testHand);

        assertEquals("Bishop your current hand is [H6, D8, DQ]", humanPlayer.toString());
    }

    @Test
    void dealHandTest(){
        Player testPlayer = new Player("Bishop");
        List testCardDeck = Main.generateDeck();
        testCardDeck = Main.removeQueens(testCardDeck);

        Main.dealHand(testPlayer, testCardDeck, (testCardDeck.size() / testNoOfPlayers));

        assertEquals((testCardDeckSizeAfterRemovalOfQueen/ testNoOfPlayers),testPlayer.getHand().size());
    }

    @Test
    void removeQueensTest(){
        List cardDeck =  Main.generateDeck();

        assertEquals(53, Main.removeQueens(cardDeck).size());
        assertEquals(1, CommonMethods.stringCount(Main.removeQueens(cardDeck).toString(), 'Q'));
    }
}
