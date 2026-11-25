class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] out = new int[temperatures.length];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
				stack.pop();
			}

			out[i] = !stack.isEmpty() ? stack.peek() - i : 0;

			stack.push(i);
		}

		return out;
    }
}
