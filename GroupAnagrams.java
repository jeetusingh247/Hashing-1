// Approach: We use a HashMap to group anagrams by their unique hash values.
// Each word is hashed by multiplying prime numbers representing each character.
// Since anagrams produce the same hash, they are grouped together in the map.
// Time : O(n x k)
// Space : O(n x k)

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Double, List<String>> map = new HashMap<>();

        for (String str : strs) { // O(n)
            double hash = getHash(str); // O(N)

            if (!map.containsKey(hash)) { // O(k)
                map.put(hash, new ArrayList<>());
            }

            map.get(hash).add(str); // O(k)
        }

        return new ArrayList<>(map.values());
    }

    private double getHash(String str) {
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        
        double hash = 1;

        for (char c : str.toCharArray()) {
            hash *= primes[c - 'a'];
        }
        
        return hash;
    }
}

