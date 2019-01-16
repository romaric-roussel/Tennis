package lp.iem.tennis;

public class Set {

    private int number;
    private Game game;
    private int nbGamesPlayer1;
    private int nbGamesPlayer2;
    private boolean isFinished;

    public Set(){
        this.number = 1;
        this.nbGamesPlayer1 = 0;
        this.nbGamesPlayer2 = 0;
        this.isFinished = false;
    }

    public Set(int number, Game game, int nbGamesPlayer1, int nbGamesPlayer2) {
        this.number = number;
        this.game = game;
        this.nbGamesPlayer1 = nbGamesPlayer1;
        this.nbGamesPlayer2 = nbGamesPlayer2;
    }
    public boolean isTieBreak(){
        return nbGamesPlayer1 == 6 && nbGamesPlayer2 == 6 ;
    }

    public boolean isFinished() {
        if(hasWinSetPlayer1() || hasWinSetPlayer2()){
            this.isFinished = true;
        }
        return isFinished;
    }

    public boolean hasWinSetPlayer1(){
        boolean win = false;
        if(nbGamesPlayer1 == 6 && nbGamesPlayer2 <5 ){
            win = true;
        }
        if(nbGamesPlayer1 == 6 && nbGamesPlayer2 == 6 ) {
            if (game.hasWinTieBreakPlayer1()) {
                win = true;
            }
        }
        if(nbGamesPlayer1 >6 && game.hasWinTieBreakPlayer1()){
            win = true;
        }
        if(nbGamesPlayer1 > 6 && (nbGamesPlayer1 - nbGamesPlayer2 ==2 )){
            win = true;
        }

        return win;
    }

    public boolean hasWinSetPlayer2(){
        boolean win = false;
        if(nbGamesPlayer2 == 6 && nbGamesPlayer1 <5 ){
            win = true;
        }
        if(nbGamesPlayer1 == 6 && nbGamesPlayer2 == 6 ) {
            if (game.hasWinTieBreakPlayer2()) {
                win = true;
            }
        }
        if(nbGamesPlayer2 >6 && game.hasWinTieBreakPlayer2()){
            win = true;
        }
        if(nbGamesPlayer2 > 6 && (nbGamesPlayer2 - nbGamesPlayer1 == 2 )){
            win = true;
        }

        return win;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getNbGamesPlayer1() {
        return nbGamesPlayer1;
    }

    public void setNbGamesPlayer1(int nbGamesPlayer1) {
        this.nbGamesPlayer1 = nbGamesPlayer1;
    }

    public int getNbGamesPlayer2() {
        return nbGamesPlayer2;
    }

    public void setNbGamesPlayer2(int nbGamesPlayer2) {
        this.nbGamesPlayer2 = nbGamesPlayer2;
    }

    public void resetSetToStart(){
        setNbGamesPlayer1(0);
        setNbGamesPlayer2(0);
        setFinished(false);
        game.resetGameToStart();
    }
}
