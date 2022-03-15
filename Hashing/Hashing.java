
//                      === Hashing ===

/*

In Hashset only unique elements are present even if you add duplicates.
By default hash set has default capacity of 16 and load factor 0.75

Constructors-
HashSet<>()
HashSet<>(initial capacity)
HashSet<>(initial capacity, loadFactor)
*/
package Hashing;
import java.util.*;
public class Hashing {
    public static void hashset() {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(6);
        hs.add(7);
        hs.add(8);
        hs.add(9);
        hs.add(6);
        // print
        System.out.println(hs);

        // contains , to check if any element is present 
        System.out.println(hs.contains(7));

        // remove element 
        hs.remove(9);

        // to check is hashset is empty
        System.out.println(hs.isEmpty());

        // Size 
        System.out.println(hs.size());

        // Clear hashset
        hs.clear();
        System.out.println(hs);

    }

    public static void hashmap(){
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int arr[] = { 10, 34, 5, 10, 3, 5, 10 };
        for (int i = 0; i < arr.length; i++) {
            // Get if the element is present
            Integer c = hmap.get(arr[i]);
            // If this is first occurrence of element
            // Insert the element
            if (hmap.get(arr[i]) == null) {
                hmap.put(arr[i], 1);
            }
            // If elements already exists in hash map
            // Increment the count of element by 1
            else {
                hmap.put(arr[i], ++c);
            }
        }
        for (int i : hmap.keySet()) {
            System.out.println("key: " + i + " value: " + hmap.get(i));
        }

        for(Map.Entry m : hmap.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
           }  
    }

    public static void main(String[] args){
        hashset();
        hashmap();
    }
}
