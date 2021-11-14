package dictionaries_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        String output = ans.stream()
                .map(Object::toString)
                .collect(joining("\n"));

        System.out.println(output);
    }

    private static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> mapNumberFrequency = new HashMap<>();
        Map<Integer, Set<Integer>> mapFrequencyNumber = new HashMap<>();
        List<Integer> finalList = new ArrayList<>();

        queries.forEach(q -> {
            int command = q.get(0);
            int numToAddRemoveCheck = q.get(1);

            if (command != 3) {
                boolean isInMapNumberFrequency = mapNumberFrequency.containsKey(numToAddRemoveCheck);
                int valueMapNumberFrequency_OLD = mapNumberFrequency.getOrDefault(numToAddRemoveCheck, 0);

                if (command == 1) {
                    int valueMapNumberFrequency_NEW = valueMapNumberFrequency_OLD + 1;
                    if (isInMapNumberFrequency) {
                        mapNumberFrequency.put(numToAddRemoveCheck, valueMapNumberFrequency_NEW);
                    } else {
                        mapNumberFrequency.put(numToAddRemoveCheck, 1);
                    }

                    if (mapFrequencyNumber.containsKey(valueMapNumberFrequency_OLD)) {
                        mapFrequencyNumber.get(valueMapNumberFrequency_OLD).remove(numToAddRemoveCheck);
                    }

                    mapFrequencyNumber.putIfAbsent(valueMapNumberFrequency_NEW, new HashSet<>());
                    mapFrequencyNumber.get(valueMapNumberFrequency_NEW).add(numToAddRemoveCheck);
                }

                if (command == 2) {
                    int valueMapNumberFrequency_NEW = valueMapNumberFrequency_OLD - 1;

                    if (isInMapNumberFrequency) {
                        if (valueMapNumberFrequency_OLD > 1) {
                            mapNumberFrequency.put(numToAddRemoveCheck, valueMapNumberFrequency_NEW);
                        } else {
                            mapNumberFrequency.remove(numToAddRemoveCheck);
                        }
                    }

                    if (mapFrequencyNumber.containsKey(valueMapNumberFrequency_OLD)) {
                        mapFrequencyNumber.get(valueMapNumberFrequency_OLD).remove(numToAddRemoveCheck);
                    }

                    if (valueMapNumberFrequency_NEW != 0) {
                        mapFrequencyNumber.putIfAbsent(valueMapNumberFrequency_NEW, new HashSet<>());
                        mapFrequencyNumber.get(valueMapNumberFrequency_NEW).add(numToAddRemoveCheck);
                    }

                }

                //case 3
            } else {
                if (numToAddRemoveCheck > queries.size()) {
                    finalList.add(0);
                } else {
                    if (mapFrequencyNumber.getOrDefault(numToAddRemoveCheck, Collections.emptySet()).size() > 0){
                        finalList.add(1);
                    } else {
                        finalList.add(0);
                    }
                }
//                if (mapNumberFrequency.containsValue(numToAddRemoveCheck)) {
//                    finalList.add(1);
//                } else {
//                    finalList.add(0);
//                }
            }
        });

        return finalList;
    }
}
