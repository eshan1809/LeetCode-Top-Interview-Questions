class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i = 1; i < strs.length; i++)
            ans = common(ans, strs[i]);
        return ans;
    }
    
    private String common(String s1, String s2){
        int i = 0;
        while(i < s1.length() && i < s2.length())
            if(s1.charAt(i) == s2.charAt(i))
                i++;
            else
                break;
        return s1.substring(0, i);
    }
}
