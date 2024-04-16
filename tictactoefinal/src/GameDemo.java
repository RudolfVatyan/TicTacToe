import java.util.Scanner;


import game.Game;
import game.Board;
import game.Player;


public class GameDemo {
    public static void main(String[] args) {

        Game game = new Game();
        game.playGame();
        String result = game.getResult();
        //System.out.println();
        //System.out.println("-----------------------");
        System.out.println("Result: " + result);
        //System.out.println();
    }
}
