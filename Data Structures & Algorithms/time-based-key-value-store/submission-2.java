class TimeMap {
        Map<String, List<Pair>> map;
    public TimeMap() {
         map = new HashMap<>();
    }

    public static class Pair{
        Integer timeStamp;
        String value;

        Pair(Integer timeStamp, String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            Pair pair = new Pair(timestamp, value);
            map.get(key).add(pair);
        //   map.put(key, map.get(key).add(pair));
        }else{
            map.put(key,new ArrayList<>());
            Pair pair = new Pair(timestamp, value);
             map.get(key).add(pair);
        //   map.put(key, map.get(key).add(pair));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
       int idx = search(key, timestamp);
       if(idx == -1){
        return "";
       }else{
        return map.get(key).get(idx).value;
       }
    }

    public int search(String key, int target) {
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        int floor = Integer.MIN_VALUE;
        while(left<=right){
            int mid = (left + right)/2;
            if(target < list.get(mid).timeStamp){
              right = mid -1;
            }else if(target > list.get(mid).timeStamp){
                floor = mid;
              left = mid +1;
            }else{
                return mid;
            }
        }
        return floor != Integer.MIN_VALUE ? floor : -1;
    }
}
