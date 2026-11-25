class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
		Deque<StringBuilder> stringStack = new ArrayDeque<>();

		StringBuilder currStr = new StringBuilder();
		int k = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				k = k * 10 + (c - '0');
			} else if (c == '[') {
				countStack.push(k);
				stringStack.push(currStr);

				k = 0;
				currStr = new StringBuilder();
			} else if (c == ']') {
				int loop = countStack.pop();
				StringBuilder parentStr = stringStack.pop();

				while (loop > 0) {
					parentStr.append(currStr);
					loop--;
				}

				currStr = parentStr;
			} else {
				currStr.append(c);
			}
		}

		return currStr.toString();
    }
}