import java.util.HashMap;
import java.util.Map;

class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] charCounts = new int[26];
        
        int windowStart = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charCounts[rightChar - 'A']++;
            
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charCounts[rightChar - 'A']);
            
            int windowLength = windowEnd - windowStart + 1;
            if (windowLength - maxRepeatLetterCount > k) {
                char leftChar = s.charAt(windowStart);
                charCounts[leftChar - 'A']--;
                windowStart++; 
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        
        return maxLength;
    }
}