class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder ans = new StringBuilder();
        String sign = (numerator < 0) ^ (denominator < 0) ? "-" : "";
        long num = Math.abs(1L * numerator), den = Math.abs(1L * denominator);
        long q = num / den, r = num % den;
        ans.append(q);
        if(r != 0){
            ans.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while(r != 0){
                if(map.containsKey(r)){
                    ans.insert(map.get(r), "(");
                    ans.append(")");
                    break;
                }
                map.put(r, ans.length());
                r *= 10;
                q = r / den;
                r %= den;
                ans.append(q);
            }
        }
        return sign + ans.toString();
    }
}
