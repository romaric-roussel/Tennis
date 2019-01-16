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

    private Player player3 = new Player("toto");
    private Player player4 = new Player("tata");
    private MatchType bo3 = MatchType.BEST_OF_THREE;
    private MatchType bo5 = MatchType.BEST_OF_FIVE;

    private Set[] setBo3 = new Set[3];
    private Set[] setBo5 = new Set[5];


    //private Game game = new Game("0","0");

    private TennisMatch tennisMatch1  = new TennisMatch(player1,player2,bo3,false);
    private TennisMatch tennisMatch2  = new TennisMatch(player1,player2,bo5,false);
    private TennisMatch tennisMatch3  = new TennisMatch(player3,player4,bo5,false);

    @Before
    public void init(){

        for(int i = 0;i<3;i++){
            setBo3[i] = new Set(i+1,new Game("0","0"),0,0);
        }
        for(int i = 0;i<5;i++){
            setBo5[i] = new Set(i+1,new Game("0","0"),0,0);
        }
        tennisMatch1.setSet(setBo3);
        tennisMatch3.setSet(setBo5);


        //set1
        tennisMatch1.getSet()[0].setNbGamesPlayer1(3);
        tennisMatch1.getSet()[0].setNbGamesPlayer2(6);
        tennisMatch1.getSet()[0].getGame().setNbTieBreakPointPlayer1(7);
        tennisMatch1.getSet()[0].getGame().setNbTieBreakPointPlayer2(5);
        //set2
        tennisMatch1.getSet()[1].setNbGamesPlayer1(6);
        tennisMatch1.getSet()[1].setNbGamesPlayer2(0);
        tennisMatch1.getSet()[1].getGame().setNbTieBreakPointPlayer1(9);
        tennisMatch1.getSet()[1].getGame().setNbTieBreakPointPlayer2(7);
        //set3
        tennisMatch1.getSet()[2].setNbGamesPlayer1(6);
        tennisMatch1.getSet()[2].setNbGamesPlayer2(6);
       // tennisMatch1.getSet()[2].getGame().setNbTieBreakPointPlayer1(7);
        //tennisMatch1.getSet()[2].getGame().setNbTieBreakPointPlayer2(0);

        tennisMatch1.getSet()[0].getGame().setNbPointPlayer1("0");
        tennisMatch1.getSet()[0].getGame().setNbPointPlayer2("A");


        tennisMatch1.getPlayer1().setNbSetWin(2);
        tennisMatch1.getPlayer2().setNbSetWin(1);
        //tennisMatch2.setCurrentSetNumber(1);

    }

    //-------------------------------------------TennisMatch TEST ---------------------------------------------------------
    @Test
    public void isFinished() {
        assertTrue(tennisMatch1.isFinished());

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
            assertNotNull(tennisMatch1.getSet()[i].getGame().getNbPointPlayer1());
            assertNotNull(tennisMatch1.getSet()[i].getGame().getNbPointPlayer2());
        }

    }

    @Test
    public void updateWithPointWonBy() {
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("0"));
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("0"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("15"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("30"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("40"));

        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("15"));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("30"));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("40"));

        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("A"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer2(),is("40"));
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("40"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("A"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbPointPlayer1(),is("0"));
        assertThat(tennisMatch3.getSet()[0].getNbGamesPlayer1(),is(1));


        tennisMatch3.getSet()[0].setNbGamesPlayer1(6);
        tennisMatch3.getSet()[0].setNbGamesPlayer2(6);
        assertThat(tennisMatch3.getSet()[0].getNbGamesPlayer1(),is(6));
        assertThat(tennisMatch3.getSet()[0].getNbGamesPlayer2(),is(6));

        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(1));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(2));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(3));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(4));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(5));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer1(),is(6));

        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(1));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(2));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(3));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(4));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(5));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(6));

        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(7));
        tennisMatch3.updateWithPointWonBy(player4);
        assertThat(tennisMatch3.getSet()[0].getGame().getNbTieBreakPointPlayer2(),is(8));

        assertTrue(tennisMatch3.getSet()[0].isFinished());
        assertThat(tennisMatch3.currentSetNumber(),is(2));

        tennisMatch3.getCurrentSet().setNbGamesPlayer1(5);
        assertThat(tennisMatch3.getCurrentSet().getNbGamesPlayer1(),is(5));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("15"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("30"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("40"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("0"));
        assertThat(tennisMatch3.getSet()[1].getNbGamesPlayer1(),is(6));
        assertTrue(tennisMatch3.getSet()[1].isFinished());

        tennisMatch3.getSet()[2].setNbGamesPlayer1(6);
        tennisMatch3.getSet()[2].setNbGamesPlayer2(4);

        tennisMatch3.getSet()[3].setNbGamesPlayer1(4);
        tennisMatch3.getSet()[3].setNbGamesPlayer2(6);

        tennisMatch3.getSet()[4].setNbGamesPlayer1(11);
        tennisMatch3.getSet()[4].setNbGamesPlayer2(10);

        player3.setNbSetWin(2);
        player4.setNbSetWin(2);

        tennisMatch3.setCurrentSetNumber(5);


        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("15"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("30"));
        tennisMatch3.updateWithPointWonBy(player3);
        assertThat(tennisMatch3.getCurrentSet().getGame().getNbPointPlayer1(),is("40"));
        tennisMatch3.updateWithPointWonBy(player3);

        assertThat(player3.getNbSetWin(),is(3));
        assertTrue(tennisMatch3.isFinished());









        tennisMatch3.displayScore();







    }

    @Test
    public void resetSetToStart(){
        tennisMatch1.getSet()[0].resetSetToStart();
        assertThat(tennisMatch1.getSet()[0].getNbGamesPlayer1(),is(0));
        assertThat(tennisMatch1.getSet()[0].getNbGamesPlayer2(),is(0));
        // assertThat(setBo3[0].getGame().getNumber(),is(0));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbPointPlayer1(),is("0"));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbPointPlayer2(),is("0"));


    }


    //---------------------------------------------------------------------Game TEST---------------------------------------------------------------------------------
    @Test
    public void resetGameToStart() {
        tennisMatch1.getSet()[0].getGame().resetGameToStart();
        //assertThat(game.getNumber(),is(0));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbPointPlayer1(), is("0"));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbPointPlayer2(), is("0"));
    }

    @Test
    public void resetTieBreakPoint() {
        tennisMatch1.getSet()[0].getGame().resetTieBreakPoint();
        //assertThat(game.getNumber(),is(0));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbTieBreakPointPlayer1(), is(0));
        assertThat(tennisMatch1.getSet()[0].getGame().getNbTieBreakPointPlayer2(), is(0));
    }



    @Test
    public void hasWinTieBreakPlayer1(){
        assertTrue(tennisMatch1.getSet()[0].getGame().hasWinTieBreakPlayer1());
        assertTrue(tennisMatch1.getSet()[1].getGame().hasWinTieBreakPlayer1());
    }

    @Test
    public void hasWinTieBreakPlayer2(){
        assertFalse(tennisMatch1.getSet()[0].getGame().hasWinTieBreakPlayer2());
        assertFalse(tennisMatch1.getSet()[1].getGame().hasWinTieBreakPlayer2());
    }


    //-----------------------------------------------------------------------Set TEST --------------------------------------------------------------
    @Test
    public void isTieBreak(){
        assertTrue(tennisMatch1.getSet()[2].isTieBreak());
        assertFalse(tennisMatch1.getSet()[0].isTieBreak());
    }

    @Test
    public void isFinishedSet(){
        assertTrue(tennisMatch1.getSet()[0].isFinished());
        assertFalse(tennisMatch1.getSet()[2].isFinished());

    }

    @Test
    public void hasWinSetPlayer1(){
        assertTrue(tennisMatch1.getSet()[1].hasWinSetPlayer1());

    }

    @Test
    public void hasWinSetPlayer2(){
        assertTrue(tennisMatch1.getSet()[0].hasWinSetPlayer2());
        assertFalse(tennisMatch1.getSet()[2].hasWinSetPlayer2());

    }





}