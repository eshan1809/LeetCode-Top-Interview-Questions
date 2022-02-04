class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        helper(0, s, "", new ArrayList<>(), list);
        return list;
    }
    
    private void helper(int i, String s, String ssf, List<String> al, List<List<String>> list){
        if(i == s.length()){
            if(ssf.length() > 0 && isPalindrome(ssf)){
                al.add(ssf);
                list.add(new ArrayList<>(al));
                al.remove(al.size() - 1);
            } else if(ssf.length() == 0)
                list.add(new ArrayList<>(al));
            return;
        }
        if(ssf.length() > 0 && isPalindrome(ssf)){
            al.add(ssf);
            helper(i + 1, s, s.charAt(i) + "", al, list);
            al.remove(al.size() - 1);
        }
        helper(i + 1, s, ssf + s.charAt(i), al, list);
    }
    
    private boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}
