package game;

public class Board {

    private char[][] gameBoard;

    public Board() {
        gameBoard = new char[3][3];
        for (int i = 0; i < 3; ++i){
            gameBoard[i][0] = ' ';
            gameBoard[i][1] = ' ';
            gameBoard[i][2] = ' ';
        }
    }

    char[][] getBoard () {
        return gameBoard;
    }

    void printBoard() {
        System.out.println(this);
    }

    boolean submitMove(String move, char player){
        if (move.length() == 2){
            if (Character.getNumericValue(move.charAt(0)) >= 1 && Character.getNumericValue(move.charAt(0)) <= 3
                    && Character.getNumericValue(move.charAt(1)) >= 1 && Character.getNumericValue(move.charAt(1)) <= 3){
                if (gameBoard[Character.getNumericValue(move.charAt(0)) - 1][Character.getNumericValue(move.charAt(1)) - 1] == ' ') {
                    gameBoard[Character.getNumericValue(move.charAt(0)) - 1][Character.getNumericValue(move.charAt(1)) - 1] = player;
                    return true;
                }
                else System.out.println("invalid place");
            }   else System.out.println("invalid move");
        }  else System.out.println("invalid move");
        //TODO: implement
        // Puts the player marker on the board if move is valid
        // move consists of 2 digits representing the row and column, like "12" (first row, second column)
        // if it is an invalid move then false is returned
        return false;
    }

    boolean isBoardFull() {
        for (int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if (gameBoard[i][j] == ' '){
                    return false;
                }
            }
        }
        //TODO: implement
        // Checks whether the board is full
        return true;
    }

    boolean isWinner(char player) {
        for (int i = 0; i < 3; ++i){
            if (player == gameBoard[i][0] && player == gameBoard[i][1] && player == gameBoard[i][2]){
                return true;
            }
            if (player == gameBoard[0][i] && player == gameBoard[1][i] && player == gameBoard[2][i]){
                return true;
            }
        }
        if (player == gameBoard[0][0] && player == gameBoard[1][1] && player == gameBoard[2][2]){
            return true;
        }
        if (player == gameBoard[0][2] && player == gameBoard[1][1] && player == gameBoard[2][0]){
            return true;
        }
        //TODO: implement
        // Checks whether 'X' or 'O' is a winner
        return false;
    }


    public String toString(){
        //coverts the board to string like:
        /*      X | O | X
                -----------
                O | X | O
                -----------
                O | X | X*/
         return "-------------\n" + "| " +
                 gameBoard[0][0] + " | " +
                 gameBoard[0][1] + " | " +
                 gameBoard[0][2] +
                 " |\n-------------\n" +
                 "| " +
                 gameBoard[1][0] + " | " +
                 gameBoard[1][1] + " | " +
                 gameBoard[1][2] +
                 " |\n-------------\n" +
                 "| " +
                 gameBoard[2][0] + " | " +
                 gameBoard[2][1] + " | " +
                 gameBoard[2][2] + " |\n-------------";
    }

}
