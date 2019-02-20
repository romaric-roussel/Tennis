package lp.iem.tennis;

public class TennisMatch {

    private Player player1;
    private Player player2;
    private MatchType matchType;
    private boolean tieBreakInLastSet;
    private int currentSetNumber;
    private Set[] set;

    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.currentSetNumber = 1;
        initSet(matchType);
    }
    public boolean isTieBreak(){
       return getCurrentSet().getNbGamesPlayer1() == 6 && getCurrentSet().getNbGamesPlayer2() == 6;
    }
    public void initSet(MatchType matchType){
        switch (matchType){
            case BEST_OF_THREE:
                Set[] setBo3 = new Set[3];
                for(int i = 0;i<3;i++){
                setBo3[i] = new Set(i+1,new Game("0","0"),0,0);
            }
            setSet(setBo3);
            break;
            case BEST_OF_FIVE:
                Set[] setBo5 = new Set[5];
                for(int i = 0;i<5;i++){
                setBo5[i] = new Set(i+1,new Game("0","0"),0,0);
            }
            setSet(setBo5);
                break;
        }


    }
    public void updateWithPointWonBy(Player player){

        if(!isFinished()){
            if(player.equals(player1)){
                if(isTieBreakNow()){
                        if(hasWinTieBreakPlayer1()){
                            updateGamePlayer1InCurrentSet();
                            updateNbSetWinPlayer1();
                            if(isFinished()){
                               //displayScore
                            }else{
                                updateCurrentSetNumber();
                            }
                        }else {
                            updateTieBreakPointPlayer1();
                        }
                }else {
                    if(!isCurrentSetFinished()){
                        updatePointPlayer1();

                    }
                }
            } else if(player.equals(player2)) {
                if(isTieBreakNow()){
                        if(hasWinTieBreakPlayer2()){
                            updateGamePlayer2InCurrentSet();
                            updateNbSetWinPlayer2();
                            if(isFinished()){
                                //displayScore
                            }else{
                                updateCurrentSetNumber();
                            }
                        }else {
                            updateTieBreakPointPlayer2();
                        }
                }else {
                    if(!isCurrentSetFinished()){
                        updatePointPlayer2();

                    }
                }
            }
        }else {
            //displayScore
        }
    }

    private boolean hasWinTieBreakPlayer2() {
        return getCurrentSet().getGame().hasWinTieBreakPlayer2();
    }

    private boolean hasWinTieBreakPlayer1() {
        return getCurrentSet().getGame().hasWinTieBreakPlayer1();
    }

    private boolean isTieBreakNow() {
        boolean bool = false;
        if((currentSetNumber != matchType.maxNumberOfSets() && isTieBreak()) || (tieBreakInLastSet && currentSetNumber == matchType.maxNumberOfSets() && isTieBreak())){
            if(getCurrentSet().isTieBreak()){
                bool = true;
            }
        }
        return bool;
    }

    private void updateTieBreakPointPlayer1() {
        getCurrentSet().getGame().setNbTieBreakPointPlayer1(getCurrentTieBreakPointPlayer1()+1);
    }

    private void updateCurrentSetNumber() {
        if(currentSetNumber < matchType.maxNumberOfSets()){
            setCurrentSetNumber(currentSetNumber + 1);
        }
    }

    private void updateTieBreakPointPlayer2() {
        getCurrentSet().getGame().setNbTieBreakPointPlayer2(getCurrentTieBreakPointPlayer2()+1);
    }

    private void updatePointPlayer2() {
        switch (getCurrentPointPlayer2()){
            case "0":
                setNbPointPlayer2(Point._15);
                break;
            case "15":
                setNbPointPlayer2(Point._30);
                break;
            case "30":
                setNbPointPlayer2(Point._40);
                break;
            case "40":
                switch (getCurrentPointPlayer1()){
                    case "40":
                        setNbPointPlayer2(Point._A);
                        break;
                    case "A":
                        setNbPointPlayer1(Point._40);
                        break;
                    default:
                        updateGamePlayer2InCurrentSet();
                        resetGameToStart();
                        if(isCurrentSetFinished()){
                            updateNbSetWinPlayer2();
                            if(isFinished()){
                                //displayScore
                            }else{
                                updateCurrentSetNumber();
                            }

                        }


                }break;
            case "A":
                updateGamePlayer2InCurrentSet();
                resetGameToStart();
                if(isCurrentSetFinished()){
                    updateNbSetWinPlayer2();
                    if(isFinished()){
                        //displayScore
                    }else{
                        updateCurrentSetNumber();
                    }

                }
                break;


        }
    }

    private void setNbPointPlayer2(Point point) {
        getCurrentSet().getGame().setNbPointPlayer2(point.getPoint());
    }

    private void updateNbSetWinPlayer2() {
        player2.setNbSetWin(player2.getNbSetWin()+1);
    }

    private boolean isCurrentSetFinished() {
        return getCurrentSet().isFinished();
    }

    private void resetGameToStart() {
        getCurrentSet().getGame().resetGameToStart();
    }

    private void updateGamePlayer2InCurrentSet() {
        getCurrentSet().setNbGamesPlayer2(getCurrentSet().getNbGamesPlayer2() + 1);
    }

    private void updatePointPlayer1() {
        switch (getCurrentPointPlayer1()){
            case "0":
                setNbPointPlayer1(Point._15);
                break;
            case "15":
                setNbPointPlayer1(Point._30);
                break;
            case "30":
                setNbPointPlayer1(Point._40);
                break;
            case "40":
                switch (getCurrentPointPlayer2()){
                    case "40":
                        setNbPointPlayer1(Point._A);
                        break;
                    case "A":
                        setNbPointPlayer2(Point._40);
                        break;
                    default:
                        updateGamePlayer1InCurrentSet();
                        resetGameToStart();
                        if(isCurrentSetFinished()){
                            updateNbSetWinPlayer1();
                            if(isFinished()){
                                //displayScore

                            }else{
                                updateCurrentSetNumber();
                            }

                        }


                }break;
            case "A":
                updateGamePlayer1InCurrentSet();
                resetGameToStart();
                if(isCurrentSetFinished()){
                    updateNbSetWinPlayer1();
                    if(isFinished()){
                        //displayScore

                    }else{
                        updateCurrentSetNumber();
                    }

                }
                break;


        }
    }

    private void setNbPointPlayer1(Point point) {
        getCurrentSet().getGame().setNbPointPlayer1(point.getPoint());
    }

    private void updateNbSetWinPlayer1() {
        player1.setNbSetWin(player1.getNbSetWin()+1);
    }

    private void updateGamePlayer1InCurrentSet() {
        getCurrentSet().setNbGamesPlayer1(getCurrentSet().getNbGamesPlayer1() + 1);
    }

    public void displayScore() {
        StringBuilder builder = new StringBuilder();
        builder.append("Match terminé. Score ");
        for (Set sets:set
        ) {
            if(sets.getGame().hasWinTieBreakPlayer1() || sets.getGame().hasWinTieBreakPlayer2()){
                builder.append(sets.getNbGamesPlayer1())
                        .append("/")
                        .append(sets.getNbGamesPlayer2())
                        .append(" (")
                        .append(sets.getGame().getNbTieBreakPointPlayer1())
                        .append("/")
                        .append(sets.getGame().getNbTieBreakPointPlayer2())
                        .append(")")
                        .append(" ");
            }else {
                builder.append(sets.getNbGamesPlayer1())
                        .append("/")
                        .append(sets.getNbGamesPlayer2())
                        .append(" ");
            }

        }
        System.out.println(builder);
    }

    private int getCurrentTieBreakPointPlayer2() {
        return getCurrentSet().getGame().getNbTieBreakPointPlayer2();
    }

    private int getCurrentTieBreakPointPlayer1() {
        return getCurrentSet().getGame().getNbTieBreakPointPlayer1();
    }

    private String getCurrentPointPlayer1() {
        return getCurrentSet().getGame().getNbPointPlayer1();
    }

    private String getCurrentPointPlayer2() {
        return getCurrentSet().getGame().getNbPointPlayer2();
    }

    public String pointsForPlayer(Player player){
        String point = "";
        if(player.equals(player1)){
            point = getCurrentSet().getGame().getNbPointPlayer1();

        }else if (player.equals(player2)) {
            point = getCurrentSet().getGame().getNbPointPlayer2();
        }
        return point;

    }

    public int gamesInCurrentSetForPlayer(Player player){
        int game =0;
        if(player.equals(player1)){
            game = getCurrentSet().getNbGamesPlayer1();
        }else if (player.equals(player2)) {
            game = getCurrentSet().getNbGamesPlayer2();
        }
        return game;
    }
    public int gamesInSetForPlayer(int setNumber, Player player){
        int game =0;
        if(player.equals(player1)){
            game = set[setNumber-1].getNbGamesPlayer1();
        }else if (player.equals(player2)) {
            game = set[setNumber-1].getNbGamesPlayer2();
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

    public Set[] getSet() {
        return set;
    }

    public Set getCurrentSet() {
        return set[currentSetNumber-1];
    }

    public void setSet(Set[] set) {
        this.set = set;
    }
}
