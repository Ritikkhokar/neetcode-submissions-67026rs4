class Solution {
    static List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList();
        if(s.length() == 0){
            ans.add(new ArrayList());
            return ans;
        }
        for(int i=1;i<s.length()+1;i++){
            if(!isPalinDrome(s.substring(0,i))){
              continue;
            }
            ArrayList<String> arr = new ArrayList();
            arr.add(s.substring(0,i));
           check(s.substring(i), arr);
        }
        return ans;
    }

    public static void check(String s, ArrayList<String> list){
        if(s.length() == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<s.length()+1;i++){
            if(!isPalinDrome(s.substring(0,i))){
              continue;
            }
           list.add(s.substring(0,i));
           check(s.substring(i), list);
           list.remove(list.size()-1);
        }
    }

    public static boolean isPalinDrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
