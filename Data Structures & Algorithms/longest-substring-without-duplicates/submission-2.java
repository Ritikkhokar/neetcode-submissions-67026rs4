class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxString = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
               while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
               }
            }
            set.add(s.charAt(i));
            maxString = Math.max(maxString, i-l+1);
        }
        return maxString;
    }
}
