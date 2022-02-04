class Solution {
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
        }
    }
    
    Node root;
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for(String word : words)
            insert(word);
        List<String> list = new ArrayList<>();
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                search(root, "", board, i, j, list, visited);
            }
        }
        return list;
    }
    
    private void insert(String s){
        Node curr = root;
        for(char ch : s.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    private void search(Node curr, String ssf, char[][] board, int i, int j, List<String> list, boolean[][] visited){
        if(curr.isEnd){
            list.add(ssf);
            curr.isEnd = false;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j])
            return;
        char ch = board[i][j];
        if(curr.children[ch - 'a'] == null)
            return;
        visited[i][j] = true;
        search(curr.children[ch - 'a'], ssf + ch, board, i + 1, j, list, visited);
        search(curr.children[ch - 'a'], ssf + ch, board, i, j + 1, list, visited);
        search(curr.children[ch - 'a'], ssf + ch, board, i - 1, j, list, visited);
        search(curr.children[ch - 'a'], ssf + ch, board, i, j - 1, list, visited);
        visited[i][j] = false;
    }
}
