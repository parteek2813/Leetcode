class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minimumStack;
    public MinStack() {
        stack = new Stack<Integer>();
        minimumStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minimumStack.isEmpty() && val > minimumStack.peek() ){
            val = minimumStack.peek();
        }
        minimumStack.push(val);
      
        
    }
    
    public void pop() {
       stack.pop();
       minimumStack.pop();
     }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
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