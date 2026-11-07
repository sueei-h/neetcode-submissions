class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
		int[] out = new int[temperatures.length];
		Arrays.fill(out, 0);

		for (int i = 0; i < temperatures.length; i++) {
			int j = i;
			int last = 0;

			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				last = stack.pop();
				out[last] = i - last;
			}

			stack.push(i);
		}

		return out;
    }
}
