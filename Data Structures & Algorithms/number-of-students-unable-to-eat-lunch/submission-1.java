class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> q = new ArrayDeque<>();

		for (int s : students) {
			q.offer(s);
		}

		int sandwichIdx = 0;
		int count = 0;

		while (!q.isEmpty() && count < q.size()) {
			if (q.peek() == sandwiches[sandwichIdx]) {
				q.poll();
				sandwichIdx++;
				count = 0;
			} else {
				q.offer(q.poll());
				count++;
			}
		}

		return count;
    }
}