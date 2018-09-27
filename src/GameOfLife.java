import java.util.Arrays;
import java.util.stream.Stream;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        //Any live cell with fewer than two live neighbors dies, as if caused by under-population.


        //[2nd bit, 1st bit] = [next state, current state]
        if (board.length == 0 ) return;
        int rowSize = board.length; int colSize = board[0].length;

        for (int row = 0; row < rowSize; ++row){
            for (int col = 0; col < colSize; ++col){
                int lives = liveNeighbors(board, rowSize, colSize, row, col);
                //Any live cell with two or three live neighbors lives on to the next generation.
                //Any live cell with more than three live neighbors dies, as if by over-population..
                if(board[row][col] == 1 && lives >= 2 && lives <= 3)
                    board[row][col] = 3; // bit : 11
                //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                if(board[row][col] == 0 && lives == 3)
                    board[row][col] = 2; // bit : 11
            }
        }
        for (int row = 0; row < rowSize; ++row)
            for (int col = 0; col < colSize; ++col)
                board[row][col] >>= 1;

    }
    private int liveNeighbors(int[][] board, int rowSize, int colSize, int row , int col){
        int lives = 0;
        for (int x = Math.max(row - 1, 0); x <= Math.min(row + 1, rowSize - 1); x++) {
            for (int y = Math.max(col - 1, 0); y <= Math.min(col + 1, colSize - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        return lives;
    }
}
