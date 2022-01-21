class MinStack {
    List<Pair> myStack;
    int size;

    public MinStack() {
        myStack = new ArrayList<>();
        size = 0;
    }
    
    public void push(int val) {
        if(size == 0)
            myStack.add(new Pair(val, val));
        else
            myStack.add(new Pair(val, Math.min(myStack.get(size - 1).min, val)));
        size++;
    }
    
    public void pop() {
        myStack.remove(--size);
    }
    
    public int top() {
        return myStack.get(size - 1).val;
    }
    
    public int getMin() {
        return myStack.get(size - 1).min;
    }
}

class Pair{
    int val, min;
    Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
