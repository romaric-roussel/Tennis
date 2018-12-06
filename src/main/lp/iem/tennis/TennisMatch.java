package lp.iem.tennis;

public class TennisMatch {

    Player player1;
    Player player2;
    MatchType matchType;
    boolean tieBreakInLastSet;

    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
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
