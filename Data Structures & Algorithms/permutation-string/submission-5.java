class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }
        int matchNeed = s1Map.size();
        int l=0;
        
        for(int i=0;i< s2.length();i++){
           if(s1Map.containsKey(s2.charAt(i))){
              if(!s2Map.containsKey(s2.charAt(i))){
               s2Map.put(s2.charAt(i),1);
               if(s2Map.get(s2.charAt(i)) == s1Map.get(s2.charAt(i))){
                matchNeed--;
               }
              }else if(s2Map.get(s2.charAt(i)) < s1Map.get(s2.charAt(i))){
               s2Map.put(s2.charAt(i),s2Map.get(s2.charAt(i))+1);
               if(s2Map.get(s2.charAt(i)) == s1Map.get(s2.charAt(i))){
                matchNeed--;
               }
             }else{
               while(s2.charAt(l) != s2.charAt(i)){
                if(s2Map.get(s2.charAt(l)) == s1Map.get(s2.charAt(l))){
                matchNeed++;
               }
               s2Map.put(s2.charAt(l),s2Map.get(s2.charAt(l))-1);
               l++;
               }
               l++;
             }
           }else{
            matchNeed = s1Map.size();
            s2Map = new HashMap<>();
            l = i+1;
           }
           if(matchNeed == 0){
            return true;
           }
        }
        return false;
    }
}
