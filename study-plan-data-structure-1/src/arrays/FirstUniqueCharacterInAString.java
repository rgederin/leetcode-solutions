package arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // put all string chars and count of appearance in map
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // iterate over chars in string and find first where appearance = 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }

        return -1;
    }
}
