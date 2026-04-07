class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];

        for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++;
        }

        for(int r = s1.length()-1;r<s2.length();r++){
            int[] s2Count = convertArray(r-(s1.length()-1), r, s2);
            boolean isPermutation = compare(s1Count, s2Count);
            if(isPermutation){
                return true;
            }
        }
        return false;
    }

    public static int[] convertArray(int l, int r, String s2){
        
        System.out.println("l = " + l);
        System.out.println("r = " + r);

        int[] s2Count = new int[26];

        for(int i=l;i<=r;i++){
            s2Count[s2.charAt(i)-'a']++;
        }
        return s2Count;
    }

    public static boolean compare(int[] s1Count , int[] s2Count){
        for(int i=0;i<26;i++){
            if(s1Count[i] != s2Count[i]){
                 return false;
            }
        }
        return true;
    }
}
