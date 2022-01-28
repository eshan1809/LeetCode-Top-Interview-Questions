class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, i = 0, j = 0, k = n - 1;
        while(j <= k){
            if(nums[j] == 0){
                nums[j++] = nums[i];
                nums[i++] = 0;
            } else if(nums[j] == 1){
                j++;
            } else{
                nums[j] = nums[k];
                nums[k--] = 2;
            }
        }
    }
}
