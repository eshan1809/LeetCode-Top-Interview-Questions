class Solution {
    class Pair implements Comparable<Pair>{
        int val, x, y;
        Pair(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(matrix[0][0], 0, 0));
        matrix[0][0] = Integer.MAX_VALUE;
        int n = matrix.length, m = matrix[0].length;
        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            if(k == 1)
                return rem.val;
            if(rem.x < n - 1 && matrix[rem.x + 1][rem.y] < Integer.MAX_VALUE){
                pq.add(new Pair(matrix[rem.x + 1][rem.y], rem.x + 1, rem.y));
                matrix[rem.x + 1][rem.y] = Integer.MAX_VALUE;
            }
            if(rem.y < m - 1 && matrix[rem.x][rem.y + 1] < Integer.MAX_VALUE){
                pq.add(new Pair(matrix[rem.x][rem.y + 1], rem.x, rem.y + 1));
                matrix[rem.x][rem.y + 1] = Integer.MAX_VALUE;
            }
            k--;
        }
        return matrix[n - 1][m - 1];
    }
}
