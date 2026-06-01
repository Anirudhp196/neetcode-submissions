class TimeMap {
    private Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> times = map.get(key);
        if(times == null) {
            return "";
        }
        int l = 0; int r = times.size() - 1;
        String largest = "";

        while(l <= r) {
            int mid = l + (r-l)/2;
            if(times.get(mid).getKey() <= timestamp) {
                largest = times.get(mid).getValue();
                l = mid+1;
            } else{
                r = mid-1;
            }
        }
        return largest;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
