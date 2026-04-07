class Solution {
    public int characterReplacement(String s, int k) {
        int[] alphabets = new int[26];
        int max = 0;
        int l = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
           alphabets[s.charAt(i)-'A']++;
           max = Math.max(max, alphabets[s.charAt(i)-'A']);

           if(i-l + 1 - max > k){
               alphabets[s.charAt(l)-'A']--;
               l++;
           }
           res = Math.max(res, i-l + 1);
        }
        return res;
    }
}
