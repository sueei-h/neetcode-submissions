class Solution {
    public String predictPartyVictory(String senate) {
		Deque<Integer> qD = new ArrayDeque<>();
		Deque<Integer> qR = new ArrayDeque<>();

		for (int i = 0; i < senate.length(); i++) {
			char c = senate.charAt(i);

			if (c == 'D') {
				qD.offer(i);
			} else if (c == 'R') {
				qR.offer(i);
			}
		}

		while (!qD.isEmpty() && !qR.isEmpty()) {
			int d = qD.poll();
			int r = qR.poll();
			
			if (r < d) {
				qR.offer(r + senate.length());
			} else if (r > d) {
				qD.offer(d + senate.length());
			}
		}
		
		if (!qD.isEmpty()) {
			return "Dire";
		}
		
		return "Radiant";
	}
}