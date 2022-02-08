class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for(int[] pre : prerequisites)
            graph[pre[0]].add(pre[1]);
        List<Integer> list = new ArrayList<>();
        boolean[] checked = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++)
            if(!checked[i] && dfs(graph, i, checked, new boolean[numCourses], numCourses, list))
                return new int[0];
        Set<Integer> set = new HashSet<>();
        int n = list.size(), idx = 0;
        int[] arr = new int[numCourses];
        for(int i : list){
            if(!set.contains(i)){
                set.add(i);
                arr[idx++] = i;
            }
        }
        return arr;
    }
    
    private boolean dfs(List<Integer>[] graph, int curr, boolean[] checked, boolean[] visited, int numCourses, List<Integer> list){
        if(visited[curr])
            return true;
        visited[curr] = true;
        for(int nbr : graph[curr])
            if(!checked[curr] && dfs(graph, nbr, checked, visited, numCourses, list))
                return true;
        checked[curr] = true;
        visited[curr] = false;
        list.add(curr);
        return false; 
    }
}
