class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(0, s, "", new HashSet<>(wordDict), new HashMap<>());
    }
    
    private boolean helper(int i, String s, String ssf, Set<String> set, Map<String, Boolean> dp){
        String p = ssf + "," + i;
        if(dp.containsKey(p))
            return dp.get(p);
        if(i == s.length()){
            boolean flag = set.contains(ssf);
            dp.put(p, flag);
            return flag;
        }
        if(set.contains(ssf) && helper(i + 1, s, s.charAt(i) + "", set, dp)){
            dp.put(p, true);
            return true;
        }
        boolean flag = helper(i + 1, s, ssf + s.charAt(i), set, dp);
        dp.put(p, flag);
        return flag;
    }
}
