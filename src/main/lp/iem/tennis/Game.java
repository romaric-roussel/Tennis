package lp.iem.tennis;

public class Game {

    private int number;
    private String nbPointPlayer1;
    private String nbPointPlayer2;
    private boolean isFinished;

    public Game(){}

    public Game(int number) {
        this.number = number;
    }

    public Game(int number, String nbPointPlayer1, String nbPointPlayer2) {
        this.number = number;
        this.nbPointPlayer1 = nbPointPlayer1;
        this.nbPointPlayer2 = nbPointPlayer2;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        setNumber(0);
        setNbPointPlayer1("0");
        setNbPointPlayer2("0");
        setFinished(false);
    }
}
