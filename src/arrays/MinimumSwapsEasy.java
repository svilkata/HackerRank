package arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumSwapsEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();


        System.out.println(minimumSwaps(arr));
        System.out.println(Arrays.stream(arr).mapToObj(x -> (x + "")).collect(Collectors.joining(" ")));
    }

    static int minimumSwaps(int[] arr) {
        int i = 0;
        int count = 0;
        int temp;
        int n = arr.length;
        while (i < n) {
            if (arr[i] != i + 1) {
                temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                count++;
            } else {
                i++;
            }
        }

        return count;

    }
}
