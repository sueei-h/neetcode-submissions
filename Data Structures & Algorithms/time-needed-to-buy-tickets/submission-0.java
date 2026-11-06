class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Deque<Integer> q = new ArrayDeque<>();
		int count = 0;

		for (int i = 0; i < tickets.length; i++) {
			q.offer(i);
		}

		while (!q.isEmpty()) {
			int index = q.pop();

			tickets[index]--;
			count++;

			if (tickets[index] > 0) {
				q.offer(index);
			}

			if (index == k && tickets[index] == 0) {
				return count;
			}
		}

		return 0;
    }
}