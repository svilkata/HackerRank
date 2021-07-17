package arrays;

import java.util.*;
import java.util.stream.Collectors;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> arr = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultArr = rotLeft(arr, tokens[1]);

        System.out.println(arr.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        d = d % a.size();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            temp.add(a.remove(0));
        }

        a.addAll(temp);

        return a;
    }
}
