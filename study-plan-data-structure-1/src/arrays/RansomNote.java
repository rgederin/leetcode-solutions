package arrays;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()){
            if (map.containsKey(ch) && map.get(ch) != 0){
                map.put(ch, map.get(ch) - 1);
            }else {
                return false;
            }
        }
        return true;
    }
}
