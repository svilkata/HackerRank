package arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayManipulationWithMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] zzz = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int nSizeOfArray = zzz[0];
        int mNumberOfCommands = zzz[1];

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, mNumberOfCommands).forEach(i -> queries.add(
                Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        ));

        int a = 5;

        long result = arrayManipulation(nSizeOfArray, queries);
        System.out.println(result);
    }

    private static long arrayManipulation(int nSizeOfArray, List<List<Integer>> queries) {
        Map<Long, Long> map = new HashMap<>();

        for (List<Integer> query : queries) {
            long start = query.get(0);
            long end = query.get(1);
            long value = query.get(2);

            map.put(start, (map.containsKey(start) ? map.get(start) : 0) + value);
            map.put(end + 1, (map.containsKey(end + 1) ? map.get(end + 1) : 0) - value);
        }

        long max = 0;
        long value = 0;
        for (long i = 0; i < nSizeOfArray; i++) {
            value += (map.containsKey(i + 1) ? map.get(i + 1) : 0);
            max = Math.max(max, value);
        }

        return max;
    }
}
