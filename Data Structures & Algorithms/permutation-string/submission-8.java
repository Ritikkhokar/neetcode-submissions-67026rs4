class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1char = new int[26];
        int[] s2char = new int[26];

        for(int i=0;i<s1.length();i++){
            s1char[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = 0;
        while( r<s2.length()){
           s2char[s2.charAt(r) - 'a']++;
           while (l<=r && s2char[s2.charAt(l) - 'a']>s1char[s2.charAt(l) - 'a']){
            s2char[s2.charAt(l) - 'a']--;
            l++;
           }
           if(Arrays.equals(s1char, s2char)){
            return true;
           }
           r++;
        }
        return false;
    }
}
