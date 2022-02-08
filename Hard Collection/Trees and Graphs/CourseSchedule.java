class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for(int[] pre : prerequisites)
            graph[pre[0]].add(pre[1]);
        boolean[] checked = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            if(!checked[i] && dfs(graph, i, checked, new boolean[numCourses], numCourses))
                return false;
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int curr, boolean[] checked, boolean[] visited, int numCourses){
        if(visited[curr])
            return true;
        visited[curr] = true;
        for(int nbr : graph[curr])
            if(!checked[curr] && dfs(graph, nbr, checked, visited, numCourses))
                return true;
        checked[curr] = true;
        visited[curr] = false;
        return false; 
    }
}
