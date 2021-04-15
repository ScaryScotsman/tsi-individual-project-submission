
import org.junit.jupiter.api.Test;
import uk.co.submission.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTests{

    @Test
    void generateCardDeckSizeTest(){
        assertEquals(56, Main.generateDeck().size());
    }
}
