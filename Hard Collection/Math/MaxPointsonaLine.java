class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length, max = 0;
        if(n < 3)
            return n;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                double slope = 0;
                int flag = 0, count = 0;
                if(points[i][0] != points[j][0])
                    slope = 1.0 * (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                else
                    flag = 1;
                for(int k = j + 1; k < n; k++){
                    if(points[i][0] == points[k][0])
                        count += flag;
                    else if(flag == 0 && 1.0 * (points[i][1] - points[k][1]) / (points[i][0] - points[k][0]) == slope)
                        count++;
                }
                max = Math.max(max, count + 2);
            }
        }
        return max;
    }
}
