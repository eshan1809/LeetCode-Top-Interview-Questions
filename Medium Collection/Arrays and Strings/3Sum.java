class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            int l = i + 1, r = n - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else if(nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else{
                    List<Integer> al = new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[l]);
                    al.add(nums[r]);
                    set.add(al);
                    l++;
                    r--;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> al : set)
            list.add(al);
        return list;
    }
}
