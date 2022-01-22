class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String str = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int curr = str.charAt(0) - '0', freq = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) - '0' == curr)
                freq++;
            else{
                sb.append(freq + "" + curr);
                curr = str.charAt(i) - '0';
                freq = 1;
            }
        }
        sb.append(freq + "" + curr);
        return sb.toString();
    }
}
