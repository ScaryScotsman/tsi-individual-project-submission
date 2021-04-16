
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.submission.CommonMethods;
import uk.co.submission.Main;

import java.io.FileNotFoundException;
import java.util.List;
import uk.co.submission.Player;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MainTests{
    public static final int testNoOfPlayers = 4;
    public static final int testCardDeckSize = 56;
    public static final int testCardDeckSizeAfterRemovalOfQueen = 53;

    private List testCardDeck;
    private Player testHumanPlayer = new Player("Ripley");
    private Player testCPU = new Player("Bishop");
    private List testHand = new ArrayList();
    private List testComparisonHand = new ArrayList();
    private double testCardsToBeDealt;

    @BeforeEach
    void setUp() {
        testCardDeck =  Main.generateDeck();
        Main.removeQueens(testCardDeck);
        testCardsToBeDealt = Math.floor(testCardDeck.size() / testNoOfPlayers);

        testHand.add("H6");
        testHand.add("D8");
        testHand.add("DQ");
        testHand.add("C6");
        testHumanPlayer.setHand(testHand);

        testComparisonHand.add("D8");
        testComparisonHand.add("DQ");
        testCPU.setHand(testComparisonHand);
    }

    @Test
    void generateCardDeckSizeTest(){
        assertEquals(testCardDeckSize, Main.generateDeck().size());
    }

    @Test
    void shuffleDeckTest(){
        assertEquals(testCardDeck.size(), Main.shuffleDeck(testCardDeck).size());
        assertNotEquals(testCardDeck.toString(), Main.shuffleDeck(testCardDeck).toString());
    }
    @Test
    void removeQueensTest(){
        assertEquals(53, Main.removeQueens(testCardDeck).size());
        assertEquals(1, CommonMethods.stringCount(Main.removeQueens(testCardDeck).toString(), 'Q'));
    }

    @Test
    void dealHandTest(){
        Main.dealHand(testHumanPlayer, testCardDeck, (int)testCardsToBeDealt);
        System.out.println(testCardsToBeDealt);
        assertEquals((testCardDeckSizeAfterRemovalOfQueen/ testNoOfPlayers), testHumanPlayer.getHand().size());
    }

    @Test
    void playerToStringTest(){
        assertEquals("Ripley your current hand is [H6, D8, DQ, C6]", testHumanPlayer.toString());
    }

    @Test
    void playPairTest(){
        testHumanPlayer.playPair();
        assertEquals(testComparisonHand, testHumanPlayer.getHand());
    }

    @Test
    void viewOtherPlayersHandTest(){
        assertEquals("Bishop currently has 2 cards.",testHumanPlayer.viewOpponentsHand(testCPU));
    }

    @Test
    void chooseOpponentsCardTest(){
        Object testCPUCard = testCPU.getHand().get(1);
        testHumanPlayer.chooseOpponentsCard(testCPU, 1);
        assert(testHumanPlayer.getHand().contains(testCPUCard));
    }

    @Test
    void readFromFileTest(){
        try{
            assertFalse(CommonMethods.readFile(CommonMethods.gameRulesPath).isEmpty());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
