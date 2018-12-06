package lp.iem.tennis;

public class TennisMatch {

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private boolean isFinished;
    private int currentSet;


    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
    }
    public void updateWithPointWonBy(Player player){

    }
    public String pointsForPlayer(Player player){
        return "";
    }
    public int gamesInCurrentSetForPlayer(Player player){
        return 1;
    }
    public int gamesInSetForPlayer(int setNumber, Player player){
        return 1;
    }

    public int currentSetNumber(){
        return currentSet;
    }

    public void setCurrentSetNumber(int currentSet){
        this.currentSet = currentSet;
    }


    public boolean isFinished(){
        return isFinished;
    }

    public void setFinished(boolean finishedMatch) {
        isFinished = finishedMatch;
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
