class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;
        //char[] h1 = s.substring(0, half).toCharArray();
        //char[] h2 = s.toCharArray();
        //fifo? add opening punctuation
        //closing punctuation should be reverse of opening;

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
