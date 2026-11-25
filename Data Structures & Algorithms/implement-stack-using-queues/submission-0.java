class MyStack {

    Deque<Integer> q1;
	Deque<Integer> q2;

	public MyStack() {
		q1 = new ArrayDeque<>();
		q2 = new ArrayDeque<>();
	}

	public void push(int x) {
		q2.offer(x);

		while (!q1.isEmpty()) {
			q2.offer(q1.poll());
		}

		Deque<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public int pop() {
		if (q1.isEmpty()) {
			throw new IllegalStateException();
		}

		return q1.poll();
	}

	public int top() {
		if (q1.isEmpty()) {
			throw new IllegalStateException();
		}

		return q1.peek();
	}

	public boolean empty() {
		return q1.isEmpty();
	}
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */