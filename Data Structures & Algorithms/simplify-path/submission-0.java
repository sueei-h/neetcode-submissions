class Solution {
    public String simplifyPath(String path) {
        Deque<String> s = new ArrayDeque<>();
        
        for (String str : path.trim().split("/+")) {
            if (str.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else if (str.equals(".") || str.isEmpty()) {
                continue;
            } else {
                s.push(str);
            }
        }
        
        StringBuilder out = new StringBuilder();
        out.append("/");
        
        while (!s.isEmpty()) {
            out.append(s.removeLast()).append("/");
        }
        
        if (out.length() > 1) {
            int a = out.lastIndexOf("/");
            out.replace(a, a + 1, "");
        }
        
        return out.toString();
    }
}