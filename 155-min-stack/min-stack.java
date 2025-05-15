class MinStack {
    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    
    public void push(int x) {
        int currentMin = stack.isEmpty() ? x : Math.min(x, stack.peek().getValue());
        stack.push(new Pair<>(x, currentMin));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}