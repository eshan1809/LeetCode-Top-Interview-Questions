class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int[][] arr = new int[map.size()][2];
        int idx = 0;
        for(int i : map.keySet()){
            arr[idx][0] = i;
            arr[idx][1] = map.get(i);
            idx++;
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        int[] ans = new int[k];
        for(int i = 0; i < k; i++)
            ans[i] = arr[i][0];
        return ans;
    }
}
