package WarmingUp;

import java.util.*;
import java.util.stream.Collectors;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> ar = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        System.out.println(sockMerchant(n, ar));



}

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>(); //we need 2 for a pair
        int pairs = 0;

        for (int i = 0; i < ar.size(); i++) {
            if (map.containsKey(ar.get(i))) {
                map.put(ar.get(i), map.get(ar.get(i)) + 1);
                if (map.get(ar.get(i)) % 2 == 0) {
                    pairs++;
                    map.put(ar.get(i), 0);
                }
            } else {
                map.putIfAbsent(ar.get(i), 1);
            }
        }

        return pairs;
    }
}
