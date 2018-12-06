package lp.iem.tennis;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TennisMatchTest {

    private Player player1 = new Player("Romaric");
    private Player player2 = new Player("Maxime");
    private MatchType bo3 = MatchType.BEST_OF_THREE;
    private MatchType bo5 = MatchType.BEST_OF_FIVE;
    private boolean tieBreakInLastSet = false;

    private TennisMatch tennisMatch1  = new TennisMatch(player1,player2,bo3,false);
    private TennisMatch tennisMatch2  = new TennisMatch(player1,player2,bo5,false);


    @Before
    public void init(){
        tennisMatch1.setFinished(true);
        tennisMatch2.setFinished(false);
        tennisMatch2.setCurrentSetNumber(1);
    }

    @Test
    public void isFinished() {
        assertTrue(tennisMatch1.isFinished());
        assertFalse(tennisMatch2.isFinished());

    }


    @Test
    public void currentSetNumber() {
        assertThat(tennisMatch2.currentSetNumber(), is(1));
    }
}