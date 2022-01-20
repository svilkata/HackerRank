package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = makeAnagram(a, b);
        System.out.println(res);
    }

    private static int makeAnagram(String first, String second) {
        // Write your code here
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < first.length(); i++) {
            if (map.get(first.charAt(i)) == null) {
                map.put(first.charAt(i), 1);
            } else {
                int cur = map.get(first.charAt(i));
                map.put(first.charAt(i), cur + 1);
            }
        }

        for (int i = 0; i < second.length(); i++) {
            if (map.containsKey(second.charAt(i))) {
                int cur = map.get(second.charAt(i));
                if (cur == 1) {
                    map.remove(second.charAt(i));
                } else {
                    map.put(second.charAt(i), cur - 1);
                }
            } else {
                count++;
            }
        }

        for (Integer i : map.values()) {
            count = count + i;
        }

        return count;
    }
}
