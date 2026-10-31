class MyQueue {

    Deque<Integer> q1;
    Deque<Integer> q2;
    
    public MyQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.push(x);
    }
    
    public int pop() {
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.push(q1.pop());
            }
        }
        
        return q2.pop();
    }
    
    public int peek() {
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.push(q1.pop());
            }
        }
        
        return q2.peek();
    }
    
    public boolean empty() {
        return q1.size() + q2.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */