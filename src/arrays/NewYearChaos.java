package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(reader.readLine().trim());

                List<Integer> q = Stream.of(reader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                NewYearChaos.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private static void minimumBribes(List<Integer> q) {
        int totalBribes = 0;

        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;

        for (int i = 0; i < q.size(); ++i) {
            if (q.get(i) == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q.get(i) == expectedSecond) {
                ++totalBribes;
                expectedSecond = expectedThird;
                ++expectedThird;
            } else if (q.get(i) == expectedThird) {
                totalBribes += 2;
                ++expectedThird;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }

        System.out.println(totalBribes);
    }
}
