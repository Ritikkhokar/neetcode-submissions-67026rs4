class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        makePartion(s, new ArrayList<>());
        return ans;
    }

    public void makePartion(String s, List<String> list){
        if(s.length() == 0){
            ans.add(new ArrayList(list));
            return;
        }

        for(int i=1;i<=s.length();i++){
            String subStr = s.substring(0,i);
            if(isPalindrome(subStr)){
               list.add(subStr);
               makePartion(s.substring(i), list);
               list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
