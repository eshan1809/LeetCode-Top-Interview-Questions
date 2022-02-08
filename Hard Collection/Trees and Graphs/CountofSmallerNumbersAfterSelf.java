class Solution {
    private int[] count;
    private int[] index;
    private int[] nums;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.count = new int[n];
        this.index = new int[n];
        this.nums = nums;
        for (int i = 0; i < n; i++)
            index[i] = i;
        mergeSort(0, n - 1);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2, j = mid + 1;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[index[i]] > nums[index[j]])
                j++;
            count[index[i]] += (j - mid - 1);
        }
        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        int[] helper = new int[high - low + 1];
        for (int i = low; i <= high; i++)
            helper[i - low] = index[i];
        int i = low, j = mid + 1, idx = low;
        while (i <= mid && j <= high)
            if (nums[helper[i - low]] <= nums[helper[j - low]])
                index[idx++] = helper[i++ - low];
            else
                index[idx++] = helper[j++ - low];
        while (i <= mid)
            index[idx++] = helper[i++ - low];
    }
}
