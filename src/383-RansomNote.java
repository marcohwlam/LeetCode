class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for(Character c : ransomNote.toCharArray()){
            if(!charCountMap.containsKey(c)) return false;
            if(charCountMap.get(c) <= 0) return false;
            charCountMap.put(c, charCountMap.get(c) - 1);
        }
        return true;
    }
}
