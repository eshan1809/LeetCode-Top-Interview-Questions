class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Pair> q = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!q.isEmpty() && (nums[i] > q.getLast().val || i >= q.getLast().idx + k))
                q.removeLast();
            while(!q.isEmpty() && (nums[i] > q.getFirst().val || i >= q.getFirst().idx + k))
                q.removeFirst();
            q.addFirst(new Pair(nums[i], i));
        }
        for(int i = k; i < n; i++){
            ans[i - k] = q.getLast().val;
            while(!q.isEmpty() && (nums[i] > q.getLast().val || i >= q.getLast().idx + k))
                q.removeLast();
            while(!q.isEmpty() && (nums[i] > q.getFirst().val || i >= q.getFirst().idx + k))
                q.removeFirst();
            q.addFirst(new Pair(nums[i], i));
        }
        ans[n - k] = q.getLast().val;
        return ans;
    }
    
    class Pair{
        int val, idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
}
