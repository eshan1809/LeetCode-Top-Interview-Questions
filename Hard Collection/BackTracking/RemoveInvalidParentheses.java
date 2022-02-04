class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        helper(0, s, "", list);
        Set<String> set = new HashSet<>();
        for(String str : list)
            set.add(str);
        list = new ArrayList<>();
        for(String str : set)
            list.add(str);
        return list;
    }
    
    private void helper(int i, String s, String ssf, List<String> list){
        if(i == s.length()){
            if(isValid(ssf)){
                if(list.isEmpty())
                    list.add(ssf);
                else{
                    int ls = list.get(0).length(), la = ssf.length();
                    if(ls < la)
                        list = new ArrayList<>();
                    if(ls <= la)
                        list.add(ssf);
                }
            }
            return;
        }
        helper(i + 1, s, ssf + s.charAt(i), list);
        if(s.charAt(i) == '(' || s.charAt(i) == ')')
            helper(i + 1, s, ssf, list);
    }
    
    private boolean isValid(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(')
                count++;
            else if(ch == ')')
                count--;
            if(count < 0)
                return false;
        }
        return count == 0;
    }
}
