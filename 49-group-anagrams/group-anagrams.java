class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> h = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);

            List<String> x = h.getOrDefault(temp , new ArrayList<>());
            x.add(s);
            h.put(temp,  x);
        }
        return new ArrayList<>(h.values());
    }
}