class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] out = new int[deck.length];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < deck.length; i++) {
            q.offer(i);
        }

        for (int card : deck) {
            if (!q.isEmpty()) {
                out[q.poll()] = card;
            }

            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        return out;
    }
}
