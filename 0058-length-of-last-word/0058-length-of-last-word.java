class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (i < s.length() - 1 && s.charAt(i + 1) != ' ') {
                count = 0;
            }
        }
        return count;
    }
}
