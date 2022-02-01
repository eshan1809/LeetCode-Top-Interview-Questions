class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        list = new ArrayList<>();
        helper(0, s, "", new HashSet<>(wordDict), "");
        return list;
    }
    
    List<String> list;
    
    private void helper(int i, String s, String ssf, Set<String> set, String ans){
        if(i == s.length()){
            if(set.contains(ssf))
                list.add(ans + ssf);
            return;
        }
        if(set.contains(ssf))
            helper(i + 1, s, "" + s.charAt(i), set, ans + ssf + " ");
        helper(i + 1, s, ssf + s.charAt(i), set, ans);
    }
}
