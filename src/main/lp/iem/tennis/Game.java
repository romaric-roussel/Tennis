package lp.iem.tennis;

public class Game {

    //private int number;
    private String nbPointPlayer1 ;
    private String nbPointPlayer2 ;
    private boolean isFinished ;
    private int nbTieBreakPointPlayer1 ;
    private int nbTieBreakPointPlayer2 ;

    public Game(){
        //this.number = 0;
        this.nbPointPlayer1 = "0";
        this.nbPointPlayer2 = "0";
        this.isFinished = false;
        this.nbTieBreakPointPlayer1 = 0;
        this.nbTieBreakPointPlayer2 = 0;

    }

    public Game(int number) {
        //this.number = number;
        this.nbPointPlayer1 = "0";
        this.nbPointPlayer2 = "0";
        this.isFinished = false;
        this.nbTieBreakPointPlayer1 = 0;
        this.nbTieBreakPointPlayer2 = 0;
    }

    public Game(int number, String nbPointPlayer1, String nbPointPlayer2) {
        //this.number = number;
        this.nbPointPlayer1 = nbPointPlayer1;
        this.nbPointPlayer2 = nbPointPlayer2;
        this.isFinished = false;
        this.nbTieBreakPointPlayer1 = 0;
        this.nbTieBreakPointPlayer2 = 0;
    }

    public boolean isFinished()
    {
        return isFinished;
    }

    public void nextGame(){
        this.nbPointPlayer1 = "0";
        this.nbPointPlayer2 = "0";
        this.isFinished = false;
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

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

   /* public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }*/

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
        //setNumber(0);
        setNbPointPlayer1("0");
        setNbPointPlayer2("0");
        setFinished(false);
    }

    public void resetTieBreakPoint(){
       setNbTieBreakPointPlayer1(0);
       setNbTieBreakPointPlayer2(0);
    }
}
