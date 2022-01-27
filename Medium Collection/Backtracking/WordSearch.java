class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(helper(board, i, j, n, m, word, 0, new boolean[n][m]))
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, int n, int m, String word, int c, boolean[][] visited){
        if(c == word.length())
            return true;
        if(i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || board[i][j] != word.charAt(c))
            return false;
        visited[i][j] = true;
        if(helper(board, i + 1, j, n, m, word, c + 1, visited))
            return true;
        if(helper(board, i - 1, j, n, m, word, c + 1, visited))
            return true;
        if(helper(board, i, j + 1, n, m, word, c + 1, visited))
            return true;
        if(helper(board, i, j - 1, n, m, word, c + 1, visited))
            return true;
        visited[i][j] = false;
        return false;
    }
}
