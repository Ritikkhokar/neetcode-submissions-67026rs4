class Solution {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }else{
                tMap.put(t.charAt(i), 1);
            }

        }

        int l = 0;
        int r = 0;
        String minimumLength ;
        boolean bool = false;
        while(r<s.length()){
            bool = areBothMapsSame(tMap,map);
            if(bool){
                break;
            }

            if(t.contains(String.valueOf(s.charAt(r)))){
                if(map.containsKey(s.charAt(r))){
                    map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
                }else{
                    map.put(s.charAt(r), 1);
                }
            }
            r++;
        }
        if(!areBothMapsSame(tMap,map)){
            return "";
        }
        if(t.contains(String.valueOf(s.charAt(l)))){
            minimumLength = s.substring(l,r);
        }else{
            l = moveLeftToNextCharacter(l,s,t);
            minimumLength =  s.substring(l,r);
        }

        while(map.get(s.charAt(l)) > tMap.get(s.charAt(l))){
            map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
            l = moveLeftToNextCharacter(l,s,t);
            if(r-l < minimumLength.length()){
                if(r== s.length()){
                    minimumLength = s.substring(l);
                }else{
                    minimumLength = s.substring(l,r+1);
                }

            }

        }


        while(r<s.length() && l<=r){
            if(t.contains(String.valueOf(s.charAt(r)))){
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
          while(map.get(s.charAt(l)) > tMap.get(s.charAt(l))){
            map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
            l = moveLeftToNextCharacter(l,s,t);
            if(r-l < minimumLength.length()){
                if(r== s.length()){
                    minimumLength = s.substring(l);
                }else{
                    minimumLength = s.substring(l,r+1);
                }

            }

        }
            }
            r++;
        }
        return minimumLength;
    }

    public static int moveLeftToNextCharacter(
            int l, String s, String t
    ){
        for(int i=l+1;i<s.length();i++){
            if(t.contains(String.valueOf(s.charAt(i)))){
                return i;
            }
        }
        return -1;
    }

    public static boolean areBothMapsSame(Map<Character, Integer> tMap, Map<Character, Integer> map){
        // System.out.println("tMap. -> " + tMap);
        // System.out.println("Map. -> " + map);
        for (Character key : tMap.keySet()) {
            if(!map.containsKey(key)){
                return false;
            }else{
                if(map.get(key) < tMap.get(key)){
                    return false;
                }
            }
        }
        return true;
    }
}
