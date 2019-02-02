class Solution {
    public void solve(char[][] board) {
        if(board.length==0) return;
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            boundryDfs(board, i, 0);
            boundryDfs(board, i, cols - 1);
        }
        for(int j = 0; j < cols; j++){
            boundryDfs(board, 0, j);
            boundryDfs(board, rows - 1, j);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == '*') 
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }           
        }
    }
    private void boundryDfs(char[][] board, int i, int j){
        int rows = board.length;
        int cols = board[0].length;
        if(i < 0 || i > rows-1 ||
           j < 0 || j > cols-1 ||
           board[i][j] != 'O') return;
        board[i][j] = '*';        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};        
        for(int k=0; k<dx.length; k++){
            boundryDfs(board, i+dx[k], j+dy[k]);
        }
    }
}
