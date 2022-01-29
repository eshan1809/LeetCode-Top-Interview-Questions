class Solution {
    public int titleToNumber(String columnTitle) {
        int i = 0, ans = 0;
        while(i < columnTitle.length())
            ans = ans * 26 + (columnTitle.charAt(i++) - 'A' + 1);
        return ans;
    }
}
