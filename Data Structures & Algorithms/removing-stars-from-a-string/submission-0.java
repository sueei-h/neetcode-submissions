class Solution {
    public String removeStars(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        
        while (!stack.isEmpty()) {
            out = out.append(stack.pop());
        }
        
        return out.reverse().toString();
    }
}
