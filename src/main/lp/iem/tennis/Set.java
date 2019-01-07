package lp.iem.tennis;

public class Set {

    private int number;
    private Game game;
    private int nbGamesPlayer1;
    private int nbGamesPlayer2;

    public Set(){

    }

    public Set(int number, Game game, int nbGamesPlayer1, int nbGamesPlayer2) {
        this.number = number;
        this.game = game;
        this.nbGamesPlayer1 = nbGamesPlayer1;
        this.nbGamesPlayer2 = nbGamesPlayer2;
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
}
