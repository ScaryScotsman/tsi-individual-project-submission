
import org.junit.jupiter.api.Test;
import uk.co.submission.CommonMethods;
import uk.co.submission.Main;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTests{

    @Test
    void generateCardDeckSizeTest(){
        assertEquals(56, Main.generateDeck().size());
    }

    @Test
    void removeQueensTest(){
        List cardDeck =  Main.generateDeck();

        //assertEquals(53, Main.removeQueens(cardDeck).size());
        assertEquals(1, CommonMethods.stringCount(Main.removeQueens(cardDeck).toString(), 'Q'));
    }
}
