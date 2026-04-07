class Pair {
    int timeStamp;
    String val;

    Pair(int timeStamp, String val){
        this.timeStamp = timeStamp;
        this.val = val;
    }
}
class TimeMap {
        Map<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        if(!map.containsKey(key)){
           List<Pair> list = new ArrayList();
           list.add(pair);
           map.put(key, list);
        }else{
           map.get(key).add(pair);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
           List<Pair> list = map.get(key);
           return search(list, timestamp);
        }else{
           return "";
        }
    }

    public static String search(List<Pair> list, int timestamp){
        int l = 0;
        int r = list.size()-1;
        int mid = 0;
        String result = "";
        while(l<=r){
            mid = (l+r)/2;
            if(list.get(mid).timeStamp == timestamp){
                return list.get(mid).val;
            }
            if(timestamp < list.get(mid).timeStamp){
                r = mid -1;
            }else{
                result = list.get(mid).val;
                l = mid+1;
            }
        }
        return result;
    }
}
