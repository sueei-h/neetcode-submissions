class Solution {
    public String removeDuplicates(String s, int k) {
        class Node {
			final char ch;
			int count;

			Node(char ch, int count) {
				this.ch = ch;
				this.count = count;
			}
		}

		Deque<Node> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!stack.isEmpty() && stack.peek().ch == c) {
				stack.peek().count++;

				if (stack.peek().count == k) {
					stack.pop();
				}
			} else {
				stack.push(new Node(c, 1));
			}
		}

		StringBuilder out = new StringBuilder();

		for (Node node : stack) {
			out.repeat(String.valueOf(node.ch), Math.max(0, node.count));
		}

		return out.reverse().toString();
    }
}