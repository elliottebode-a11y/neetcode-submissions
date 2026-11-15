class Solution {
    public boolean isValid(String s) {        
        HashMap<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');
        Stack<Character> open = new Stack<>();

        for (char c : s.toCharArray()) {
            System.out.println(c);
            if (c == '[' || c == '{' || c == '(') {
                open.push(c);
            } else {
                if (open.isEmpty()) return false;
                if (open.pop() != pair.get(c)) return false;
            }
        }
        return open.isEmpty();
    }
}
