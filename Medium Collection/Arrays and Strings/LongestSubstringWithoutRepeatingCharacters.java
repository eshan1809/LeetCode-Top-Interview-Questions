class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            while(set.contains(ch))
                set.remove(s.charAt(i - set.size()));
            set.add(ch);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
