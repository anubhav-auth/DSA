class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);

            if (map.containsKey(current) && map.get(current) >= l) {
                l = map.get(current) + 1;
            }

            map.put(current, r);
            maxSize = Math.max(maxSize, r - l + 1);
        }

        return maxSize;
    }
}
