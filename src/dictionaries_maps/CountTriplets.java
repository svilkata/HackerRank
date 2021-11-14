package dictionaries_maps;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountTriplets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long commonRatio = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        System.out.println(countTriplets(arr, commonRatio));
    }

    private static long countTriplets(List<Long> arr, long commonRatio) {
        long count = 0;
        Map<Long, Long> before = new HashMap<>();
        Map<Long, Long> after = new HashMap<>();

        for (Long v : arr) {
            if (after.containsKey(v)) {
                after.put(v, after.get(v) + 1);
            } else {
                after.put(v, 1L);
            }
        }

        for (Long v : arr) {
            after.put(v, after.get(v) - 1); //current element is v, that's why we decrease the after

            if (before.containsKey(v / commonRatio) && v % commonRatio == 0 && after.containsKey(v * commonRatio)) {
                count += before.get(v / commonRatio) * after.get(v * commonRatio);
            }

            if (before.containsKey(v)) {
                before.put(v, before.get(v) + 1);
            } else {
                before.put(v, 1L);
            }
        }

        return count;

//        Map<Long, Long> potential = new HashMap<>();
//        Map<Long, Long> counter = new HashMap<>();
//        int count = 0;
//
//        for (int i = 0; i < arr.size(); i++) {
//            long a = arr.get(i);
//            long key = a / commonRatio;
//
//            if (counter.containsKey(key) && a % commonRatio == 0) {
//                count += counter.get(key);
//            }
//
//            if (potential.containsKey(key) && a % commonRatio == 0) {
//                long c = potential.get(key);
//                counter.put(a, counter.getOrDefault(a, 0L) + c);
//            }
//
//            potential.put(a, potential.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
//        }
//
//        return count;
    }
}
