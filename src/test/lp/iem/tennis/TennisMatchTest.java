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

    private Set[] setBo3 = new Set[3];
    private Set[] setBo5 = new Set[5];


    private Game game = new Game(0,"0","0");

    private TennisMatch tennisMatch1  = new TennisMatch(player1,player2,bo3,false);
    private TennisMatch tennisMatch2  = new TennisMatch(player1,player2,bo5,false);

    @Before
    public void initBo3(){

        game.setFinished(false);

        for(int i = 0;i<3;i++){
            setBo3[i] = new Set(i+1,game,0,0);
        }

        //set1
        setBo3[0].setNbGamesPlayer1(3);
        setBo3[0].setNbGamesPlayer2(6);
        //set2
        setBo3[1].setNbGamesPlayer1(6);
        setBo3[1].setNbGamesPlayer2(0);
        //set3
        setBo3[2].setNbGamesPlayer1(5);
        setBo3[2].setNbGamesPlayer2(5);

        game.setNbPointPlayer1("0");
        game.setNbPointPlayer2("A");

        tennisMatch1.setSet(setBo3);
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
            assertNotNull(setBo3[i].getGame().getNbPointPlayer1());
            assertNotNull(setBo3[i].getGame().getNbPointPlayer2());
        }

    }
    @Test
    public void resetGameToStart(){
        game.resetGameToStart();
        //assertThat(game.getNumber(),is(0));
        assertThat(game.getNbPointPlayer1(),is("0"));
        assertThat(game.getNbPointPlayer2(),is("0"));
        assertFalse(game.isFinished());
    }

    @Test
    public void resetSetToStart(){
        setBo3[0].resetSetToStart();
        assertThat(setBo3[0].getNbGamesPlayer1(),is(0));
        assertThat(setBo3[0].getNbGamesPlayer2(),is(0));
       // assertThat(setBo3[0].getGame().getNumber(),is(0));
        assertThat(setBo3[0].getGame().getNbPointPlayer1(),is("0"));
        assertThat(setBo3[0].getGame().getNbPointPlayer2(),is("0"));
        assertFalse(game.isFinished());

    }

}