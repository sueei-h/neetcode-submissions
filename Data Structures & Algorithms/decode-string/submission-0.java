class Solution {
    public String decodeString(String s) {
		Deque<String> stringStack = new ArrayDeque<>();
		Deque<Integer> countStack = new ArrayDeque<>();

		int k = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				k = k * 10 + (c - '0');
			} else if (c == '[') {
				countStack.push(k);
				k = 0;
				stringStack.push(String.valueOf(c));
			} else if (Character.isAlphabetic(c)) {
				stringStack.push(String.valueOf(c));
			} else if (c == ']') {
				StringBuilder str = new StringBuilder();
				while (!stringStack.isEmpty() && !stringStack.peek().equals("[")) {
					str.insert(0, stringStack.pop());
				}

				int loop = countStack.pop();

				StringBuilder res = new StringBuilder();

				while (loop > 0) {
					res.append(str);
					loop--;
				}

				stringStack.pop();
				stringStack.push(res.toString());
			}
		}

		StringBuilder result = new StringBuilder();
		while (!stringStack.isEmpty()) {
			result.insert(0, stringStack.pop());
		}

		return result.toString();
	}
}