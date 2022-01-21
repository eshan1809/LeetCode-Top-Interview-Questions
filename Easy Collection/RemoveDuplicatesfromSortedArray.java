class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int prev = nums[0], idx = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != prev){
                prev = nums[i];
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
