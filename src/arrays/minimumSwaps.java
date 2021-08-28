package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class minimumSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(x -> Integer.parseInt(x))
                .toArray();

        System.out.println(minimumSwaps(arr));
        System.out.println(Arrays.stream(arr).mapToObj(x -> (x + "")).collect(Collectors.joining(" ")));



    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int countOfSwaps = 0;
        int n = arr.length;

        for (int k = 0; k < n - 1; k++) { //брой операции

            for (int i = 0; i < n - k - 1; i++) { //размени два съседни, като всеки път следващи два съседни взема
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    countOfSwaps++;
                }
            }
        }



//        for (int i = 0; i < arr.length - 1; i++) {
//            int indexOfMinForTheRest= findMinForTheRest(arr, i);
//            if (arr[i] > arr[indexOfMinForTheRest]) {
//                swap(arr, i, indexOfMinForTheRest);
//                countOfSwaps++;
//            }
//        }
        return countOfSwaps;

    }

    private static int findMinForTheRest(int[] arr, int i) {
        int indexOfMinElement = i+1;
        int minElement = arr[i+1];
        for (int j = i+1; j < arr.length-1; j++) {
            if (minElement > arr[j+1]) {
                minElement = arr[j+1];
                indexOfMinElement = j+1;
            }
        }

        return indexOfMinElement;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
