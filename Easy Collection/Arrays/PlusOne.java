class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length, carry = 1;
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--){
            int add = digits[i] + carry;
            ans[i] = add % 10;
            carry = add / 10;
        }
        if(carry == 0)
            return ans;
        int[] nans = new int[n + 1];
        nans[0] = carry;
        for(int i = 0; i < n; i++)
            nans[i + 1] = ans[i];
        return nans;
    }
}
