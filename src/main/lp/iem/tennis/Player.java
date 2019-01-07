package lp.iem.tennis;

public class Player {

    private String player;
    private Set[] set;
    private int nbSetWin;

    public Player(){}

    public Player(String player) {
        this.player = player;
    }


    public String getName() {
        return player;
    }

    public void setName(String player) {
        this.player = player;
    }

    public Set[] getSet() {
        return set;
    }

    public void setSet(Set[] set) {
        this.set = set;
    }

    public int getNbSetWin() {
        return nbSetWin;
    }

    public void setNbSetWin(int nbSetWin) {
        this.nbSetWin = nbSetWin;
    }
}
