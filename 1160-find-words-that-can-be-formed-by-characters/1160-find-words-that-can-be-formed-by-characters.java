class Solution {
    public int countCharacters(String[] words, String chars) {
        // storing the chars in a HashMap
        int count = 0;
        Map<Character, Integer> charmap = new HashMap<>();
        for(char c: chars.toCharArray()) {
            charmap.put(c, charmap.getOrDefault(c, 0) +1);
        }

        // checking for every string(word) in the array
        for(String w : words) {
            if(helper(w, new HashMap<>(charmap))) count += w.length();
        }
        return count;
    }

    public boolean helper(String word, Map<Character, Integer> map) {
        // traversing with every character present in the word array(word -> Stirng)
        for(char c : word.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c) -1);
        }
        return true;
    }
}