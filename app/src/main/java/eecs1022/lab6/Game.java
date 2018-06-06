package eecs1022.lab6;

/**
 * Created by user on 2018-03-23.
 */

public class Game {

    String playerOneName;
    String playerTwoName;
    boolean someoneWon = false;
    boolean boardFull = false;


    boolean playerXTurn = true;
    boolean playerOTurn = !playerXTurn;
    char playerToPlayNext = '.';


    char[][] board = {
            {'.','.','.'},
            {'.','.','.'},
            {'.','.','.'}
    };

    Game(String playerOne, String PlayerTwo) {
        this.playerOneName = playerOne;
        this.playerTwoName = PlayerTwo;
    }

    Game(){}

    // Put this in the frontend
    public void checkingWhoPlaysFirst(String whoPlaysFirst){
        if (whoPlaysFirst.equals("X")){
            playerToPlayNext = 'X';
        }
        else{
            playerToPlayNext = 'O';
        }
    }
    // Call this once game starts
    public String displayBoard(){
        String result = "Current Game Status \n";
        for(int row = 0; row < board.length ; row ++) {
            result += "\n";
            for (int col = 0; col < board[row].length; col++){
                result +=  " " + board[row][col] + " ";
            }
        }

            result += "\n Next player to play is " + this.playerToPlayNext;

        return result;
    }
    public String displayBoardFinal(){
        String result = "Current Game Status \n";
        for(int row = 0; row < board.length ; row ++) {
            result += "\n";
            for (int col = 0; col < board[row].length; col++){
                result +=  " " + board[row][col] + " ";
            }
        }
        if(checkForWin()){
            turnChange();
            result += " \n Game Over Player "  + playerToPlayNext + " Won";
            someoneWon = true;
        } else if (isBoardFull()){
            result += " \n Its a Tie. Start a new Game";
            boardFull =true;
        }

        return result;
    }

//    public char whosTurnNegate(){
//        if (whosTurn() == 'X'){
//            return 'O';
//        }else {
//            return 'X';
//        }
//    }
//
//
//    public String nextToplay(){
//        if (whosTurn()==('X')){
//            return playerOneName;
//        }
//        else{
//            return playerTwoName;
//        }
//    }

    ///////// CHECK IF BOARDS FULL ///////////

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }


    /// Check FOR OVERALL WIN

    public boolean checkForWin() {
        return (checkRowsForWin() || checkColssForWin() || checkDiagForWin());
    }


    ////// CHECK IF SLOTH IS OCCUPIED /////

    public boolean isSlothEmpty(int r, int c){
        return board[r-1][c-1] ==  '.';
    }

    //// CHECK FOR ROW WIN ///

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }
    //// CHECK FOR COLS WIN ///

    private boolean checkColssForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }
    //// CHECK FOR COLS WIN ///

    private boolean checkDiagForWin() {
        if ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) ||
                (checkRowCol(board[0][2], board[1][1], board[2][0]) == true) ){
            return true;
        }
        return false;
    }

    /////////// Check if the selected areas are the same /////////

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '.') && (c1 == c2) && (c2 == c3));
    }


    public void turnChange(){
        if (playerToPlayNext == 'X'){
            playerToPlayNext = 'O';
        }
        else if (playerToPlayNext == 'O')
        {
            playerToPlayNext = 'X';
        }

    }

    // depending on what the whosturn() method gives. it draws O or X on board

    public void drawPlayerTurn(int row, int col){
        board[row -1][col -1] = this.playerToPlayNext;
        turnChange();
    }



    public String play(int row, int col){
        String result = "";

        if (!someoneWon){
            if (isSlothEmpty(row, col)){

                if (checkForWin()){
                    result = displayBoardFinal();
                }
                else {
                    drawPlayerTurn(row, col);
                    result = displayBoard();
                    if (checkForWin()){
                        result = displayBoardFinal();
                    }
                }
            }
            else{
                return "Error: Sloth @ (" + Integer.toString(row) + "," + Integer.toString(col) + ") already taken";
            }
        }
        else {
            result += "GAME ALREADY OVER";
        }


        return result;
    }


}
