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
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int len = 0;

            // Parse the length without creating a temporary String
            while (str.charAt(i) != '#') {
                len = len * 10 + (str.charAt(i) - '0');
                i++;
            }

            i++; // Skip '#'

            // Extract the entire string directly
            result.add(str.substring(i, i + len));
            i += len;
        }

        return result;
    }
}
