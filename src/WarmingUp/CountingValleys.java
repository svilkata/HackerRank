package WarmingUp;

import java.util.Scanner;

public class CountingValleys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int steps = Integer.parseInt(sc.nextLine());
        String path = sc.nextLine();

        System.out.println(countingValleys(steps, path));

    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int level = 0;
        int[] arr = new int[steps];
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'D') {
                arr[i] = --level;
            } else if (path.charAt(i) == 'U') {
                arr[i] = ++level;
            }
        }

        int brValleys = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                continue;
            }

            if (arr[i] < 0) {
                while (arr[i] < 0) {
                    i++;
                }
                brValleys++;
            }
        }


        return brValleys;
    }
}
