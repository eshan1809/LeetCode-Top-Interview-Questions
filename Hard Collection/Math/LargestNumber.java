class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++)
            arr[i] = nums[i];
        Arrays.sort(arr, new Comparator<Integer>(){
           @Override
            public int compare(Integer i1, Integer i2){
                String f1 = i1 + "" + i2, f2 = i2 + "" + i1;
                return f2.compareTo(f1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i : arr)
            sb.append(i);
        int i = 0;
        while(i < sb.length() - 1 && sb.charAt(i) == '0')
            i++;
        return sb.substring(i).toString();
    }
}
