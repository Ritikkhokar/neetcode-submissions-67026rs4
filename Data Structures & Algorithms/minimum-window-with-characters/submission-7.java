class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
            count.put(c, 0);
        }
        boolean foundFirst = false;
        int matchCount = 0;
        String matchedString = s+"x";
        for(int r=0;r< s.length();r++){
            if(countT.containsKey(s.charAt(r))){
               if(!foundFirst){
                l = r;
                foundFirst = true;
               }
                count.put(s.charAt(r),count.get(s.charAt(r))+1);
                if(countT.get(s.charAt(r)) == count.get(s.charAt(r))){
                    matchCount++;
                }
                if(matchCount == countT.size()){
                    l = squeeze(l,r,s,count, countT);
                    if(r-l+1<matchedString.length()){
                        matchedString = s.substring(l,r+1);
                    }
                }
            }
        }
        if(matchedString.length()>s.length()){
            matchedString = "";
        }
        return matchedString;
    }

    public static int squeeze(int l, int r, String s, Map<Character, Integer> count, Map<Character, Integer> countT){
      while(l<r){
        if(count.containsKey(s.charAt(l))){
          if(count.get(s.charAt(l)) == countT.get(s.charAt(l))){
            break;
          }else{
            count.put(s.charAt(l),count.get(s.charAt(l))-1);
          }
        }
        l++;
      }
      return l;
    }
}
