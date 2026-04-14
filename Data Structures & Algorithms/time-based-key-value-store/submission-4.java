class Pair {
    int time;
    String value;

    Pair(int time, String value){
        this.time = time;
        this.value = value;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
           map.get(key).add(new Pair(timestamp, value));
        }else{
           map.put(key, new ArrayList<>());
           map.get(key).add(new Pair(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            int l=0;
            int r = list.size()-1;
            String ans = "";
           while(l<=r){
            int mid = (l+r)/2;
            if(list.get(mid).time>timestamp){
               r = mid -1;
            }else{
               ans = list.get(mid).value;
               l = mid+1;
            }
           }
           return ans;
        }else{
            return "";
        }
    }
}
