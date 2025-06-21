class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a, b)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            b[s2.charAt(i) - 'a']++;                      // add right char
            b[s2.charAt(i - s1.length()) - 'a']--;        // remove left char

            if (Arrays.equals(a, b)) return true;
        }

        return false;
    }
}
