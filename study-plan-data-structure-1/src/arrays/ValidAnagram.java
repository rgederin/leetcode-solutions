package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    /**
     * Runtime: 12 ms, faster than 22.54% of Java online submissions for Valid Anagram.
     * Memory Usage: 39.5 MB, less than 49.44% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char ch : t.toCharArray()){
            if (map.containsKey(ch) && map.get(ch) != 0){
                map.put(ch, map.get(ch) - 1);
            }else {
                return false;
            }
        }

        return true;
    }


}
