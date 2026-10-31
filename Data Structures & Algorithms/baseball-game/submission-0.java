class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : operations) {
            if (!s.equals("+") && !s.equals("D") && !s.equals("C")) {
                stack.push(Integer.parseInt(s));
            } else if (!stack.isEmpty() && s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else if (!stack.isEmpty() && s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (!stack.isEmpty() && s.equals("C")) {
                stack.pop();
            }
        }

        int out = 0;

        while (!stack.isEmpty()) {
            out += stack.pop();
        }

        return out;
    }
}