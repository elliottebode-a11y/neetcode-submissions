class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //maintain answer list
        //create hashmap of each string?
        //compare histogram to other maps
        //add to appropriate list
        int curGroup = 0;
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            char[] chars = str.toCharArray();
            for (char c : chars) {
                freq[c - 'a']++;
            }
            String k = Arrays.toString(freq);
            hm.putIfAbsent(k, new ArrayList<>());
            hm.get(k).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
