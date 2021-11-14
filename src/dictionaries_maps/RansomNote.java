package dictionaries_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class RansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());


        checkMagazine(magazine, note);

    }

    private static void checkMagazine(List<String> magazine, List<String> notes) {
        Map<String, Integer> magMap = new LinkedHashMap<>();
        Map<String, Integer> notesMap = new LinkedHashMap<>();

        magazine.forEach(word -> {
            if (!magMap.containsKey(word)) {
                magMap.put(word, 1);
            } else {
                magMap.put(word, magMap.get(word) + 1);
            }
        });

        notes.forEach(word -> {
            if (!notesMap.containsKey(word)) {
                notesMap.put(word, 1);
            } else {
                notesMap.put(word, notesMap.get(word) + 1);
            }
        });

        System.out.println(magMap);
        System.out.println(notesMap);

        for (Map.Entry<String, Integer> notesEntry : notesMap.entrySet()) {
            if (magMap.containsKey(notesEntry.getKey())) {
                if (magMap.get(notesEntry.getKey()) < notesEntry.getValue()) {
                    System.out.println("No");
                    return;
                }

            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
