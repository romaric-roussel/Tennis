package lp.iem.tennis;

public class Simulate {

    public static void main(String [] args){

         Player player1 = new Player("Romaric");
         Player player2 = new Player("Maxime");
         MatchType bo5 = MatchType.BEST_OF_FIVE;
         TennisMatch tennisMatch1  = new TennisMatch(player1,player2,bo5,true);
        do{
            int random = (int )(Math.random() * 2 + 1);
            if(random > 1){
                tennisMatch1.updateWithPointWonBy(player1);

            }else {
                tennisMatch1.updateWithPointWonBy(player2);

            }
            //tennisMatch4.displayScores();
        }while (!tennisMatch1.isFinished());
        tennisMatch1.displayScore();
    }
}
