class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int m3 = i % 3, m5 = i % 5;
            if(m3 == 0 && m5 == 0)
                list.add("FizzBuzz");
            else if(m5 == 0)
                list.add("Buzz");
            else if(m3 == 0)
                list.add("Fizz");
            else
                list.add(i + "");
        }
        return list;
    }
}
