class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = nums[0], second = Integer.MAX_VALUE, n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] > second)
                return true;
            else if(nums[i] > first)
                second = nums[i];
            else
                first = nums[i];
        }
        return false;
    }
}
