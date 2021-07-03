package warmingUp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfClouds = Integer.parseInt(sc.nextLine());
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        System.out.println(jumpingOnClouds(list));
    }

    public static int jumpingOnClouds(List<Integer> list) {
        int minJumps = 0;
        //first element is always zero

        int i = 0;
        while (i <= list.size()-1) {
            if (i == list.size()-2) { //предпоследния елемент
                if (list.get(i + 1) == 0) {
                    minJumps++;
                    i += 1;
                }
                break;
            }

            if (list.get(i + 2) == 0) {
                minJumps++;
                i += 2;
            } else if (list.get(i + 1) == 0) {
                minJumps++;
                i += 1;
            }

            if (i == list.size()-1) {
                break;
            }
        }


        return minJumps;
    }
}
