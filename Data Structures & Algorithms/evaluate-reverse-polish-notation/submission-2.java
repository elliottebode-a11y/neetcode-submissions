class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            try {
                stack.push(Integer.parseInt(s));
            } catch (Exception e) {
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (s.equals("-")) {
                    int first = stack.pop();
                    stack.push(stack.pop() - first);
                } else if (s.equals("/")) {
                    int first = stack.pop();
                    stack.push(stack.pop() / first);
                }
            }
        }
        return stack.pop();
    }
}
