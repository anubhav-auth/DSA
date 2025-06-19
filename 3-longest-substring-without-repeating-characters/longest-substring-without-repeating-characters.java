class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) return 0;
        int l = 0, r = 0, maxSize = 0;

        HashSet<Character> hs = new HashSet<>();
        
        while(r < s.length()){

            if(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }else{
                hs.add(s.charAt(r));
                maxSize = (maxSize > hs.size())? maxSize : hs.size();
                r++;
            }
        }
        return maxSize;
    }
}