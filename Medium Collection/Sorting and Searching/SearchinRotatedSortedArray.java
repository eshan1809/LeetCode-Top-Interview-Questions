class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = n - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(target == nums[mid])
                return mid;
            if(nums[mid] >= nums[lo]){
                if(target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else{
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}
