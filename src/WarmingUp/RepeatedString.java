package WarmingUp;

import java.util.Scanner;

public class RepeatedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long n = Long.parseLong(sc.nextLine());

        System.out.println(repeatedString(s, n));

    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long count = 0L;
        StringBuilder sb = new StringBuilder(s);

        if (sb.length() >= n) {
            for (int i = 0; i < n; i++) {
                if (sb.charAt(i) == 'a') {
                    count++;
                }
            }
            return count;
        } else {
            //how many times a is contained in s
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'a') {
                    count++;
                }
            }


            long numberOfTimesSgenerated = n / sb.length();
            long remainigCharacters = n % sb.length();
            count *= numberOfTimesSgenerated;

            for (int i = 0; i < remainigCharacters; i++) {
                if (sb.charAt(i) == 'a') {
                    count++;
                }
            }

            return count;
        }
    }
}
