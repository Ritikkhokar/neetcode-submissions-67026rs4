class Solution {
    public int characterReplacement(String s, int k) {
        int l =0;
        int[] count = new int[26];
        int ans = 0;
        int mostFrequent = 0;
        for(int r = 0;r<s.length();r++){
            count[s.charAt(r)-'A']++;
            mostFrequent = findMostFrequent(count);
            while((r-l+1 - mostFrequent)>k){
                count[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
    public static int findMostFrequent(int[] count){
        int max = 0;
        for(int i=0;i<count.length;i++){
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
