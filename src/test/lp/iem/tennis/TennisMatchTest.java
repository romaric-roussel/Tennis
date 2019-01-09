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

    private Set set1 = new Set();
    private Set set2 = new Set();
    private Set set3 = new Set();
    private Set set4 = new Set();
    private Set set5 = new Set();
    private Game game0 = new Game();

    private TennisMatch tennisMatch1  = new TennisMatch(player1,player2,bo3,false);
    private TennisMatch tennisMatch2  = new TennisMatch(player1,player2,bo5,false);

    Set[] sets = new Set[3];



    @Before
    public void init(){

        //set1
        set1.setNbGamesPlayer1(3);
        set1.setNbGamesPlayer2(6);
        set1.setNumber(1);
        //set2
        set2.setNbGamesPlayer1(6);
        set2.setNbGamesPlayer2(0);
        set2.setNumber(2);
        //set3
        set3.setNbGamesPlayer1(5);
        set3.setNbGamesPlayer2(5);
        set3.setNumber(3);

        game0.setNumber(0);
        game0.setNbPointPlayer1("0");
        game0.setNbPointPlayer2("A");

        set1.setGame(game0);
        set2.setGame(game0);
        set3.setGame(game0);

        sets[0] = set1;
        sets[1] = set2;
        sets[2] = set3;

        tennisMatch1.getPlayer1().setSet(sets);
        tennisMatch1.getPlayer2().setSet(sets);
        tennisMatch1.getPlayer1().setNbSetWin(2);
        tennisMatch2.getPlayer2().setNbSetWin(3);
        tennisMatch1.setCurrentSetNumber(1);
        tennisMatch2.setCurrentSetNumber(1);
    }

    @Test
    public void isFinished() {
        assertTrue(tennisMatch1.isFinished());
        assertTrue(tennisMatch2.isFinished());

    }

    @Test
    public void currentSetNumber() {
        assertThat(tennisMatch2.currentSetNumber(), is(1));
    }

    @Test
    public void gamesInCurrentSetForPlayer() {
        assertThat(tennisMatch1.gamesInCurrentSetForPlayer(player1), is(3));
        assertThat(tennisMatch1.gamesInCurrentSetForPlayer(player2), is(6));
    }
    @Test
    public void gamesInSetForPlayer() {
        assertThat(tennisMatch1.gamesInSetForPlayer(1,player1), is(3));
        assertThat(tennisMatch1.gamesInSetForPlayer(2,player2), is(0));
    }

    @Test
    public void pointsForPlayer() {
        assertThat(tennisMatch1.pointsForPlayer(player1),is("0"));
        assertThat(tennisMatch1.pointsForPlayer(player2), is("A"));
        for(int i =0 ; i<tennisMatch1.getMatchType().maxNumberOfSets();i++){
            assertNotNull(player1.getSet()[i].getGame().getNbPointPlayer1());
            assertNotNull(player2.getSet()[i].getGame().getNbPointPlayer2());
        }

    }

}