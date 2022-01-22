class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            char ch1 = s.charAt(l), ch2 = s.charAt(r);
            boolean b1 = Character.isLetterOrDigit(ch1), b2 = Character.isLetterOrDigit(ch2);
            if(b1 && b2){
                if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2))
                    return false;
                l++;
                r--;
            }
            if(!b1)
                l++;
            if(!b2)
                r--;
        }
        return true;
    }
}
