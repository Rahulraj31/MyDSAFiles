
//                      === Hashing  Hashset ===

/*

In Hashset only unique elements are present even if you add duplicates.
By default hash set has default capacity of 16 and load factor 0.75

Constructors-
HashSet<>()
HashSet<>(initial capacity)
HashSet<>(initial capacity, loadFactor)
*/

import java.util.*;
public class Hashing {
    public static void main(String[] args) {
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
}
