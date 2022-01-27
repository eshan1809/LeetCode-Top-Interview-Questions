class Solution {
    List<List<Integer>> list;
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        list = new ArrayList();
        List<Integer> al = new ArrayList();
        generatePermutations(0, nums, used, al);
        return list;
    }
    
    public void generatePermutations(int l, int[] nums, boolean[] used, List<Integer> al){
        if(l == nums.length){
            list.add(new ArrayList<>(al));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i] == false){
                used[i] = true;
                al.add(nums[i]);
                generatePermutations(l + 1, nums, used, al);
                al.remove(al.size() - 1);
                used[i] = false;
            }
        }
    }
    
}
