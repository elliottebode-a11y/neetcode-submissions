class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        //if (n % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            if (si == '(' || si == '{' || si == '[') {
                stack.push(si);
            } 
            if (stack.isEmpty()) return false;
            if (si == ')') {
                if (stack.pop() != '(') return false;
            } else if (si == '}') {
                if (stack.pop() != '{') return false;
            } else if (si == ']') {
                if (stack.pop() != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
