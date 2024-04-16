package game;
import java.util.Random;
public class Bot extends Player{
    Random rand = new Random();
    private int myMarkers;
    private enum Level {Easy, Medium, Hard};

    public void setL() {
        System.out.println("1: Hard\n2: Medium\n3: Easy" + "\nEnter the level by number");
        int lev = sc.nextInt();
        switch(lev){
            case 1:
                l = Level.Hard;
                break;
            case 2:
                l = Level.Medium;
                break;
            case 3:
                l = Level.Easy;
                break;
            default:
                break;
        }
    }

    public Level getL() {
        return l;
    }

    private Level l;

    public char getOpp_marker() {
        return opp_marker;
    }

    public void setOpp_marker(char opp_marker) {
        this.opp_marker = opp_marker;
    }

    private char opp_marker;
    Bot() {
        super('O');
        myMarkers = 0;
        opp_marker = this.opp_marker;
    }
    Bot(char marker){
        super(marker);
        myMarkers = 0;
    }
    String getMove(Board board){
        String result = "11";
        switch(this.l){
            case Hard:
                result = hard(board);
                break;
            case Medium:
                result = medium(board);
            case Easy:
                result = easy(board);
                break;
            default:
                break;
        }
        return result;
    }

    String easy(Board board){
        System.out.println(board);
        System.out.println();
        int free_x = 0;
        int free_y = 0;
        while(true){
            free_x = rand.nextInt(3);
            free_y = rand.nextInt(3);
            if (board.getBoard()[free_x][free_y] == ' '){
                break;
            }
        }
        return Integer.toString(free_x + 1) + Integer.toString(free_y + 1);
    }
    String medium(Board board){
        System.out.println(board);
        System.out.println();
        if (myMarkers == 0){
            if (board.getBoard()[1][2] == ' '){
                myMarkers += 1;
                return "23";
            }
            else if (board.getBoard()[1][0] == ' '){
                myMarkers += 1;
                return "21";
            }
        }
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                if (board.getBoard()[i][j] == ' '){
                    board.getBoard()[i][j] = this.getMarker();
                    if (board.isWinner(this.getMarker())){
                        board.getBoard()[i][j] = ' ';
                        return Integer.toString(i + 1) + Integer.toString(j + 1);
                    } else board.getBoard()[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                if (board.getBoard()[i][j] == ' '){
                    board.getBoard()[i][j] = this.getOpp_marker();
                    if (board.isWinner(getOpp_marker())){
                        board.getBoard()[i][j] = ' ';
                        return Integer.toString(i + 1) + Integer.toString(j + 1);
                    } else board.getBoard()[i][j] = ' ';
                }
            }
        }
        int free_x = 0;
        int free_y = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getBoard()[i][j] == ' '){
                    free_x = i;
                    free_y = j;
                }
                if (board.getBoard()[i][j] == this.getMarker()) {
                    if (i + 1 < 3 && board.getBoard()[i + 1][j] == ' ' && i + 2 < 3 && board.getBoard()[i + 2][j] == ' ') {
                        return Integer.toString(i + 2) + Integer.toString(j + 1);
                    }
                    if (j + 1 < 3 && board.getBoard()[i][j + 1] == ' ' && j + 2 < 3 && board.getBoard()[i][j + 2] == ' ') {
                        return Integer.toString(i + 1) + Integer.toString(j + 2);
                    }
                    if (i - 1 >= 0 && board.getBoard()[i - 1][j] == ' ' && i - 2 >= 0 && board.getBoard()[i - 2][j] == ' ') {
                        return Integer.toString(i) + Integer.toString(j + 1);
                    }
                }
            }
        }
        return Integer.toString(free_x + 1) + Integer.toString(free_y + 1);
    }
    String hard(Board board){
        System.out.println(board);
        System.out.println();
        if (myMarkers == 0){
            if (board.getBoard()[1][1] == ' '){
                myMarkers += 1;
                return "22";
            }
            else if (board.getBoard()[0][0] == ' '){
                myMarkers += 1;
                return "11";
            }
        }
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                if (board.getBoard()[i][j] == ' '){
                    board.getBoard()[i][j] = this.getMarker();
                    if (board.isWinner(this.getMarker())){
                        board.getBoard()[i][j] = ' ';
                        return Integer.toString(i + 1) + Integer.toString(j + 1);
                    } else board.getBoard()[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 3; ++j){
                if (board.getBoard()[i][j] == ' '){
                    board.getBoard()[i][j] = this.getOpp_marker();
                    if (board.isWinner(getOpp_marker())){
                        board.getBoard()[i][j] = ' ';
                        return Integer.toString(i + 1) + Integer.toString(j + 1);
                    } else board.getBoard()[i][j] = ' ';
                }
            }
        }
        int free_x = 0;
        int free_y = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board.getBoard()[i][j] == ' '){
                    free_x = i;
                    free_y = j;
                }
                if (board.getBoard()[i][j] == this.getMarker()) {
                    if (i + 1 < 3 && board.getBoard()[i + 1][j] == ' ' && i + 2 < 3 && board.getBoard()[i + 2][j] == ' ') {
                        return Integer.toString(i + 2) + Integer.toString(j + 1);
                    }
                    if (j + 1 < 3 && board.getBoard()[i][j + 1] == ' ' && j + 2 < 3 && board.getBoard()[i][j + 2] == ' ') {
                        return Integer.toString(i + 1) + Integer.toString(j + 2);
                    }
                    if (i - 1 >= 0 && board.getBoard()[i - 1][j] == ' ' && i - 2 >= 0 && board.getBoard()[i - 2][j] == ' ') {
                        return Integer.toString(i) + Integer.toString(j + 1);
                    }
                    if (j - 1 >= 0 && board.getBoard()[i][j - 1] == ' ' && j - 2 >= 0 && board.getBoard()[i][j - 2] == ' ') {
                        return Integer.toString(i + 1) + Integer.toString(j);
                    }
                    if (j - 1 >= 0 && i - 1>= 0 && board.getBoard()[i - 1][j - 1] == ' ' && i + 1 < 3 && j + 1 < 3 && board.getBoard()[i + 1][j + 1] == ' ') {
                        return Integer.toString(i) + Integer.toString(j);
                    }
                    if (j - 1 >= 0 && i + 1 < 3 && board.getBoard()[i + 1][j - 1] == ' ' && i - 1 >= 0 && j + 1 < 3 && board.getBoard()[i - 1][j + 1] == ' ') {
                        return Integer.toString(i + 2) + Integer.toString(j);
                    }
                    if (j - 1 >= 0 && board.getBoard()[i][j - 1] == ' ' && j + 1 < 3 && board.getBoard()[i][j + 1] == ' ') {
                        return Integer.toString(i + 1) + Integer.toString(j);
                    }
                }
            }
        }
        return Integer.toString(free_x + 1) + Integer.toString(free_y + 1);
    }
}
