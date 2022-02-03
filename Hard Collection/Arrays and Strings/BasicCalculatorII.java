class Solution {
    public int calculate(String s) {
        int n = s.length(), prev = 0;
        boolean flag = false;
        Stack<Integer> od = new Stack<>();
        Stack<Character> or = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                prev = prev * 10 + (ch - '0');
                flag = true;
            } else{
                if(flag){
                    od.add(prev);
                    prev = 0;
                    flag = false;
                }
                if(ch != ' '){
                    while(!or.isEmpty() && prio(ch) <= prio(or.peek()))
                        od.add(solve(od.pop(), od.pop(), or.pop()));
                    or.add(ch);
                }
            }
        }
        if(flag)
            od.add(prev);
        while(!or.isEmpty())
            od.add(solve(od.pop(), od.pop(), or.pop()));
        return od.peek();
    }
    
    private int prio(char ch){
        if(ch == '+' || ch == '-')
            return 1;
        else
            return 2;
    }
    
    private int solve(int num2, int num1, char op){
        if(op == '+')
            return num1 + num2;
        if(op == '-')
            return num1 - num2;
        if(op == '*')
            return num1 * num2;
        return num1 / num2;
    }
}
