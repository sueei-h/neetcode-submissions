class MinStack {
    private final Deque<Integer> data = new ArrayDeque<>();
    private final Deque<Integer> min = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int value) {
        data.push(value);

        if (min.isEmpty() || value < min.peek()) {
            min.push(value);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        min.pop();
        data.pop();
    }

    public int top() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }

        return data.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            throw new NoSuchElementException();
        }

        return min.peek();
    }
}
