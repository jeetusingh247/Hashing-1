// two strings are isomorphic if all occurence are replaceable.
// here we use char array and boolean array
// we can also solve it using two hashmap for 2 way comparisons
// or we can use a hashmap and a hashset


class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sMap = new char[256];
        // HashMap<Character, Character> sMap = new HashMap<>();
        // HashMap<Character, Character> tMap = new HashMap<>();
        // HashSet<Character> set = new HashSet<>();
        boolean[] set = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sMap[sChar - ' '] != 0) {
                if (sMap[sChar - ' '] != tChar) {
                    return false;
                }
            } else {
                if(set[tChar - ' ']) return false;
                sMap[sChar - ' '] = tChar;
                set[tChar - ' '] = true;
            }

            // if (tMap.containsKey(tChar)) {
            //     if (tMap.get(tChar) != sChar) {
            //         return false;
            //     }
            // } else {
            //     tMap.put(tChar, sChar);
            // }
        }
        return true; // Return true if no mismatch found
    }
}
