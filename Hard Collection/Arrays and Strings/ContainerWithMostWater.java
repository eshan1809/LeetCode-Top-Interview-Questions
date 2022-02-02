class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            int idx1 = i, idx2 = i;
            for(int j = 0; j <= i; j++){
                if(height[j] >= height[i]){
                    idx1 = j;
                    break;
                }
            }
            for(int j = height.length - 1; j >= i; j--){
                if(height[j] >= height[i]){
                    idx2 = j;
                    break;
                }
            }
            int area = (idx2 - idx1)* height[i];
            if(area > max){
                max = area;
            }
        }
        return max;
    }
}
