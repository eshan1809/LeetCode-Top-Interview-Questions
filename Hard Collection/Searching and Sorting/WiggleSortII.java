class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length, j = 1;
        for(int i = n - 1; i > n / 2; i--, j += 2)
            nums[j] = arr[i];
        if((n & 1) == 0){
            nums[j] = arr[n / 2];
            j = n - 2;
        } else{
            j = n - 1;
        }
        for(int i = 0; j >= 0; i++, j -= 2)
            nums[j] = arr[i];
    }
}
