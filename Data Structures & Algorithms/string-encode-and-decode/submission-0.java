class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String i : strs) {
            sb.append(i.length() + "#");
            sb.append(i);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            StringBuilder intstr = new StringBuilder();
            while (c != '#') {
                intstr.append(c);
                i++;
                c = str.charAt(i);
            }
            int len = Integer.parseInt(intstr.toString());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                i++;
                sb.append(str.charAt(i));
            }
            sol.add(sb.toString());
        }
        return sol;
    }
}
