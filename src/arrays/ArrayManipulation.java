package arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ArrayManipulation {
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

    public static long arrayManipulation(int nSizeOfArray, List<List<Integer>> queries) {
        // Write your code here
        long maxElement = Long.MIN_VALUE;
        long[] arr = new long[nSizeOfArray];
        for (List<Integer> query : queries) {
            for (int i = query.get(0)-1; i <= query.get(1)-1 ; i++) {
                arr[i]+= query.get(2);
                if (maxElement < arr[i]) {
                    maxElement = arr[i];
                }
            }
        }

        return maxElement;

    }
}
