class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = 0, maxFreq = 0, maxSize = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            hm.put(c , hm.getOrDefault(c, 0) + 1);
            maxFreq = (maxFreq > hm.get(c)) ? maxFreq: hm.get(c);
            
            int windowLength = r-i+1; 

            if( (windowLength - maxFreq ) > k){
                hm.put(s.charAt(i), hm.get(s.charAt(i))-1);
                i++;
            }
            maxSize = (maxSize> (r-i+1)) ? maxSize: (r-i+1);
        }

        return maxSize;

    }
}