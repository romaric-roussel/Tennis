package lp.iem.tennis;

public class TennisMatch {

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private boolean isFinished;
    private int currentSetNumber;



    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
    }
    public void updateWithPointWonBy(Player player){

    }
    public String pointsForPlayer(Player player){
        String point = "";
        if(player.equals(player1)){
            point = player.getSet()[currentSetNumber-1].getGame().getNbPointPlayer1();
        }else if (player.equals(player2)) {
            point = player.getSet()[currentSetNumber-1].getGame().getNbPointPlayer2();
        }
        return point;

    }

    public int gamesInCurrentSetForPlayer(Player player){
        int game =0;
        if(player.equals(player1)){
            game = player.getSet()[currentSetNumber-1].getNbGamesPlayer1();
        }else if (player.equals(player2)) {
            game = player.getSet()[currentSetNumber-1].getNbGamesPlayer2();
        }
        return game;
    }
    public int gamesInSetForPlayer(int setNumber, Player player){
        int game =0;
        if(player.equals(player1)){
            game = player.getSet()[setNumber-1].getNbGamesPlayer1();
        }else if (player.equals(player2)) {
            game = player.getSet()[setNumber-1].getNbGamesPlayer2();
        }
        return game;
    }

    public int currentSetNumber(){
        return currentSetNumber;
    }

    public void setCurrentSetNumber(int currentSetNumber){
        this.currentSetNumber = currentSetNumber;
    }


    public boolean isFinished(){
        if(player1.getNbSetWin() == matchType.numberOfSetsToWin() || player2.getNbSetWin() == matchType.numberOfSetsToWin()){
            return true;
        }
        return false;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public boolean isTieBreakInLastSet() {
        return tieBreakInLastSet;
    }

    public void setTieBreakInLastSet(boolean tieBreakInLastSet) {
        this.tieBreakInLastSet = tieBreakInLastSet;
    }


}
