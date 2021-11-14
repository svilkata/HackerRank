package dictionaries_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class TwoStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();
                String s2 = bufferedReader.readLine();

                System.out.println(twoStrings(s1, s2));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static String twoStrings(String s1, String s2) {
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
                return "YES";
            }
        }

        return "NO";
    }
}
