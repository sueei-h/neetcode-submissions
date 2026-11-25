class Solution {
    public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int i : asteroids) {
			boolean alive = true;

			while (i < 0 && alive && !stack.isEmpty() && stack.peek() > 0) {
				if (Math.abs(stack.peek()) == Math.abs(i)) {
					alive = false;
					stack.pop();
					break;
				} else if (Math.abs(stack.peek()) > Math.abs(i)) {
					alive = false;
					break;
				} else {
					stack.pop();
				}
			}

			if (alive) {
				stack.push(i);
			}
		}

		int[] out = new int[stack.size()];
		int i = 0;

		for (int s : stack) {
			out[i++] = s;
		}

		return out;
	}
}