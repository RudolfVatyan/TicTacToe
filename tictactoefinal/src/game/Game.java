package game;
import java.util.Scanner;
public class Game {
    public static Scanner scan = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Bot computer;
    private Board board;

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player();
        this.computer = new Bot();
        this.board = new Board();
    }

    public Game(Board board){
        this.player1 = new Player();
        this.player2 = new Player();
        this.computer = new Bot();
        this.board = new Board();
    }

    public Game(Board board, Player player1, Bot computer, Player player2){
        this.player1 = new Player();
        this.player2 = new Player();
        this.computer = new Bot();
        this.board = new Board();
    }

    public String playGame() {
        System.out.println("for game vs computer enter 1");
        System.out.println("for 2 players game enter 2");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("insert your name");
            scan.nextLine();
            String name1 = scan.nextLine();
            player1.setName(name1);
            System.out.println("insert your marker");
            char m = scan.next().charAt(0);
            player1.setMarker(m);
            if (m == 'X'){
                computer.setMarker('O');
                computer.setOpp_marker('X');
            } else {
                computer.setMarker('X');
                computer.setOpp_marker('O');
            }
            computer.setL();
            char pl;
            System.out.println("if you want to start the game enter 1 else enter 2");
            choice = scan.nextInt();
            if (choice == 1) {
                pl = player1.getMarker();
            } else pl = computer.getMarker();
            while (!board.isBoardFull()) {
                if (pl == player1.getMarker()){
                    System.out.println(player1.getName() + " your move");
                }
                if (!board.submitMove((pl == player1.getMarker() ? player1 : computer).getMove(board), pl)) {
                    continue;
                }
                if (board.isWinner(pl)) {
                    System.out.println(board);
                    return "player " + pl + " wins";
                }
                if (pl == player1.getMarker())
                    pl = computer.getMarker();
                else pl = player1.getMarker();
            }
        } else if (choice == 2) {
            System.out.println("insert player1 name");
            scan.nextLine();
            String name1 = scan.nextLine();
            player1.setName(name1);
            System.out.println("insert player1 marker");
            char m = scan.next().charAt(0);
            player1.setMarker(m);
            System.out.println("insert player2 name");
            scan.nextLine();
            name1 = scan.nextLine();
            player2.setName(name1);
            player2.setMarker(player1.getMarker() == 'X' ? 'O' : 'X');
            char pl;
            System.out.println("if you want player1 to start the game enter 1 else enter 2");
            choice = scan.nextInt();
            if (choice == 1) {
                pl = player1.getMarker();
            } else pl = player2.getMarker();
            while (!board.isBoardFull()) {
                System.out.println((pl == player1.getMarker()?player1.getName():player2.getName()) + " your move");
                if (!board.submitMove((pl == player1.getMarker() ? player1 : player2).getMove(board), pl)) {
                    continue;
                }
                if (board.isWinner(pl)) {
                    System.out.println(board);
                    return "player " + pl + " wins";
                }
                if (pl == player1.getMarker())
                    pl = player2.getMarker();
                else pl = player1.getMarker();
            }
        }
        System.out.println(board);
        //TODO: implement
        // Plays the game:
        // 1. Prints the board
        // 2. Asks from a current player to make a move
        // 3. Submits the move, if the move was submitted then continues from point 1 the same thing for the other player,
        //    if the move was not submitted (invalid move) then prints appropriate message and asks to make a move again from the same player
        // Keeps doing the above steps until one of the players wins, or the board gets full and no one wins
        // At the end this method should print the final result of the board and return the marker of the winner or the word "Tie" if no one wins
        return "no one wins";
    }

    public String getResult(){
        if (board.isWinner('X')){
            return "player1 wins";
        }
        else if (board.isWinner('O')){
            return "player2 wins";
        }
        return "draw";
        //TODO: implement
        // returns the result of the game: the marker of the winner or the word "Tie"
    }
}
