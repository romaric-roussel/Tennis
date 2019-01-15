package lp.iem.tennis;

public class Game {


    private String nbPointPlayer1 ;
    private String nbPointPlayer2 ;
    private int nbTieBreakPointPlayer1 ;
    private int nbTieBreakPointPlayer2 ;

    public Game(){

        this.nbPointPlayer1 = "0";
        this.nbPointPlayer2 = "0";
        this.nbTieBreakPointPlayer1 = 0;
        this.nbTieBreakPointPlayer2 = 0;

    }


    public Game( String nbPointPlayer1, String nbPointPlayer2) {
        this.nbPointPlayer1 = nbPointPlayer1;
        this.nbPointPlayer2 = nbPointPlayer2;
        this.nbTieBreakPointPlayer1 = 0;
        this.nbTieBreakPointPlayer2 = 0;
    }

    public boolean hasWinTieBreakPlayer1(){
        boolean win = false;
        if((nbTieBreakPointPlayer1 == 7 && nbTieBreakPointPlayer2 <6) || (nbTieBreakPointPlayer1 > 7 && (nbTieBreakPointPlayer1 - nbTieBreakPointPlayer2 == 2))){
            win = true;
        }
        return win;
    }
    public boolean hasWinTieBreakPlayer2(){
        boolean win = false;
        if((nbTieBreakPointPlayer2 == 7 && nbTieBreakPointPlayer1 <6) || (nbTieBreakPointPlayer2 > 7 && (nbTieBreakPointPlayer2 - nbTieBreakPointPlayer1 == 2))){
            win = true;
        }
        return win;
    }

    public int getNbTieBreakPointPlayer1() {
        return nbTieBreakPointPlayer1;
    }

    public void setNbTieBreakPointPlayer1(int nbTieBreakPointPlayer1) {
        this.nbTieBreakPointPlayer1 = nbTieBreakPointPlayer1;
    }

    public int getNbTieBreakPointPlayer2() {
        return nbTieBreakPointPlayer2;
    }

    public void setNbTieBreakPointPlayer2(int nbTieBreakPointPlayer2) {
        this.nbTieBreakPointPlayer2 = nbTieBreakPointPlayer2;
    }



    public String getNbPointPlayer1() {
        return nbPointPlayer1;
    }

    public void setNbPointPlayer1(String nbPointPlayer1) {
        this.nbPointPlayer1 = nbPointPlayer1;
    }

    public String getNbPointPlayer2() {
        return nbPointPlayer2;
    }

    public void setNbPointPlayer2(String nbPointPlayer2) {
        this.nbPointPlayer2 = nbPointPlayer2;
    }

    public void resetGameToStart(){

        this.nbPointPlayer1 = "0";
        this.nbPointPlayer2 = "0";

    }

    public void resetTieBreakPoint(){
      this.nbTieBreakPointPlayer1 = 0;
      this.nbTieBreakPointPlayer2 = 0;
    }
}
