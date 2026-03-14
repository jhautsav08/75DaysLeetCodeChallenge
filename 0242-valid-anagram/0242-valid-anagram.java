class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int index = c - 'a';
            count[index]++;
        }
        for(int j = 0; j < t.length(); j++ ){
            char d = t.charAt(j);
            int index = d - 'a';
            count[index]--;
        }
        for(int k = 0; k < count.length; k++ ){
            if( count[k] != 0  ){
                return false;
            }
        }
        return true;
    }
}