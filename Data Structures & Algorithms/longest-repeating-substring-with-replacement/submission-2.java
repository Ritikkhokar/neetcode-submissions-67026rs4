class Solution {
    public int characterReplacement(String s, int k) {
       int[] alphabets = new int[26];
       int l=0; 
       int mostFreq = 0;
       int res = 0;
       for(int r=0;r<s.length();r++){
          alphabets[s.charAt(r) - 'A']++;
          mostFreq = Math.max(mostFreq, alphabets[s.charAt(r) - 'A']);
          if(r-l+1-mostFreq>k){
            alphabets[s.charAt(l) - 'A']--;
            l++;
          }
          res = Math.max(res, r-l+1);
       }
       return res;
    }
}
