class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                dfs(graph, i, visited);
            }
        }
        return count;
    }
    
    private void dfs(List<Integer>[] graph, int i, boolean[] visited){
        if(visited[i])
            return;
        visited[i] = true;
        for(int j : graph[i])
            dfs(graph, j, visited);
    }
}
