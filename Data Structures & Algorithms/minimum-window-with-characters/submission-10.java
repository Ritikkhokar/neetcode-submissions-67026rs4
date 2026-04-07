class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        Map<Character, Integer> mapt = new HashMap<>();
        Map<Character, Integer> mapSlide = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
            mapSlide.put(c, 0);
        }
        String ans = "";
        int matchCount = 0;
        int l=0;
        for(int r=0;r< s.length();r++){
            // put in map
        if(mapSlide.containsKey(s.charAt(r))){
         mapSlide.put(s.charAt(r), mapSlide.get(s.charAt(r)) + 1);
        }else{
            continue;
        }
        //  match count check
         if(mapSlide.get(s.charAt(r)) == mapt.get(s.charAt(r))){
            matchCount++;
         }
        //  string found check
         if(matchCount == mapt.size()){
            l = squeeze(l,r,s,mapSlide,mapt);
            if(ans.length() == 0 || ans.length() > r-l+1){
                ans = s.substring(l,r+1);
            }
         }

        }
        return ans;
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
