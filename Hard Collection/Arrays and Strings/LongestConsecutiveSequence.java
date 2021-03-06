class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums)
            pq.add(i);
        int longest = 1, curr = 1, start = pq.remove();
        while(pq.size() > 0){
            if(pq.peek() == start + 1){
                curr++;
                start++;
                pq.remove();
            } else if(pq.peek() == start)
                pq.remove();
            else{
                longest = Math.max(longest, curr);
                curr = 1;
                start = pq.remove();
            }
        }
        return Math.max(longest, curr);
    }
}
