package tictactoe;

public class TicTacToe {

    enum Cell {E, X ,O};
    enum Status {GNF, XWIN, OWIN, DRAW};

    private Status gameStatus;
    private Cell[][] board;

    private Cell nextMove;

    public TicTacToe() {
        board = new Cell[3][3];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Cell.E;
            }
        }
        nextMove = Cell.X;
        gameStatus = Status.GNF;
    }
    public boolean isFinished(){
        return gameStatus != Status.GNF;
    }

    public String getStatusMessage() {
        switch (gameStatus) {
            case GNF:
                return "Game not finished";
            case XWIN:
                return "X wins";
            case OWIN:
                return "O wins";
            case DRAW:
                return "Draw";
            default:
                return "Impossible";
        }
    }

    public void play_coor(int i, int j) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (board[i][j] != Cell.E)
            throw new IllegalArgumentException("Coordinate is occupied!");
        board[i][j] =  nextMove;
        check_isFull();
        check_oWin();
        check_xWin();
        nextMove = nextMove == Cell.X ? Cell.O : Cell.X;
    }

    public void check_isFull() {
        for(Cell[] row : board) {
            for(Cell c : row) {
                if (c == Cell.E) {
                    return;
                }
            }
        }
        gameStatus = Status.DRAW;
    }

    public void check_oWin() {
        //Check row
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] != Cell.O)
                    break;
                if (j == board[i].length - 1)
                    gameStatus = Status.OWIN;
            }
        }
        //Check col
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[j][i] != Cell.O)
                    break;
                if (j == board[i].length - 1)
                    gameStatus = Status.OWIN;
            }
        }
        //Check diag
        if ((board[0][0] == Cell.O && board[1][1] == Cell.O && board[2][2] == Cell.O)
                || (board[0][2] == Cell.O && board[1][1] == Cell.O && board[2][0] == Cell.O)) {
            gameStatus = Status.OWIN;
        }

    }

    public void check_xWin() {
        //Check row
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] != Cell.X)
                    break;
                if (j == board[i].length - 1)
                    gameStatus = Status.XWIN;
            }
        }
        //Check col
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (board[j][i] != Cell.X)
                    break;
                if (j == board[i].length - 1)
                    gameStatus = Status.XWIN;
            }
        }
        //Check diag
        if ((board[0][0] == Cell.X && board[1][1] == Cell.X && board[2][2] == Cell.X)
                || (board[0][2] == Cell.X && board[1][1] == Cell.X && board[2][0] == Cell.X)) {
            gameStatus = Status.XWIN;
        }

    }

    public String toString() {
        String result = "";
        result += "---------\n";
        for(Cell[] row : board) {
            result += "| ";
            for(Cell c : row) {
                if (c == Cell.E) {
                    result += " " + " ";
                } else {
                    result += c + " ";
                }
            }
            result += "|\n";
        }
        result += "---------\n";
        return result;
    }


}
