package game;
import java.util.Scanner;

public class Player {
    public static Scanner sc = new Scanner(System.in);
    private char marker;
    private String name;

    public Player() {
        this.marker = 'X';
    }

    public Player(char marker) {
        this.marker = marker;
    }

    public Player(char marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    char getMarker() {
        return marker;
    }

    String getMove(Board board) {
        System.out.println(board);
        String move;
        System.out.println("enter the move");
        move = sc.nextLine();
        //TODO: implement
        // Prints the board, asks from the player to make a move, returns the move
        return move;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override public boolean equals(Object player) {
        if(!(player instanceof Player))
            return false;
        if (this == player)
                return true;
        if (((Player) player).getName().equals(this.getName()) && ((Player) player).getMarker() == this.getMarker())
                return true;
        return false;
    }
    @Override public String toString(){
        return "name: " + this.name + "\nmarker: " + this.marker;
    }

    public void setMarker(char marker) {
        this.marker = marker;
    }
}
