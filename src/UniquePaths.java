/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.stream.IntStream;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        //upper and left boarder is alwasys 1
        for (int i = 0; i < m ; i++) board[i][0] = 1;
        for (int i = 0; i < n ; i++) board[0][i] = 1;
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                board[m][n] =  board[m-1][n] +  board[m][n-1];
            }
        }
        return board[m][n];
    }
}
