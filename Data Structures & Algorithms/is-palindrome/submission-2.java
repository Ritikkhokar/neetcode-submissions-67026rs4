class Solution {
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        // System.out.println(s);
        int i=0;
        int j = s.length()-1;
        while(i<j){
        while (i < j && !alphaNum(s.charAt(i))) {
                i++;
            }
        while (i < j && !alphaNum(s.charAt(j))) {
                j--;
            }
        
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                System.out.println("i -> "+s.charAt(i) + " j -> "+ s.charAt(j) );
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}
