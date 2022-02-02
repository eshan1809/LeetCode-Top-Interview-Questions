class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = countNeighbours(board, i, j, n, m);
                if(board[i][j] == 1 && count < 2)
                    board[i][j] = -1;
                else if(board[i][j] == 1 && count > 3)
                    board[i][j] = -1;
                else if(board[i][j] == 0 && count == 3)
                    board[i][j] = 2;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == -1)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }
    }
    
    private int countNeighbours(int[][] board, int i, int j, int n, int m){
        int count = 0;
        if(i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1))
            count++;
        if(i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1))
            count++;
        if(i > 0 && j < m - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1))
            count++;
        if(j < m - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == -1))
            count++;
        if(i < n - 1 && j < m - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1))
            count++;
        if(i < n - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == -1))
            count++;
        if(i < n - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1))
            count++;
        if(j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1))
            count++;
        return count;
    }
}
