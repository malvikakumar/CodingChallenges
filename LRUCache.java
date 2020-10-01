import java.util.*;
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

     @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println((cache.get(1)));      // returns 1
        cache.put(3, 3);    // evicts key 2 (as access order is true, least recently accessed is removed, which is 2; For insertion order hashmap, 1 would be removec)
        System.out.println((cache.get(2)));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println((cache.get(1)));       // returns -1 (not found)
        System.out.println((cache.get(3)));       // returns 3
        System.out.println((cache.get(4)));       // returns 4

    }
}

//TC: O(1), SC: O(capacity)

// In insertion-ordered linked hash maps, merely changing the value associated with a key that is already contained in the map is not a structural modification. 
// In access-ordered linked hash maps, merely querying the map with get is a structural modification. ) 
// Refer: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html