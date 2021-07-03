package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TwoDArrayDS_01 {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(reader.readLine().split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = hourglassSum(arr);

        System.out.println(result);

    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int maxSum = Integer.MIN_VALUE;
        int startingPointX = 0;
        int startingPointY = 0;

        for (startingPointX = 0; startingPointX <= 3; startingPointX++) {
            for (startingPointY = 0; startingPointY <= 3 ; startingPointY++) {
                int currSum = 0;

                for (int i = startingPointX; i <= startingPointX + 2; i++) {
                    for (int j = startingPointY; j <= startingPointY + 2; j++) {
//                                !((i == startingPointX || i == startingPointX +2) && (j == startingPointY +1))
                        if (i == startingPointX +1){
                            if (j == startingPointY || j == startingPointY +2) {
                                continue;
                            }
                        }
                        currSum += arr.get(i).get(j);
                    }
                }

                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }

        }

        return maxSum;
    }

}


