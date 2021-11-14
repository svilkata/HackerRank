package dictionaries_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();
                System.out.println(sherlockAndAnagrams(s));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private static int sherlockAndAnagrams(String str) {
        int total = 0;
        for (int i = 1; i < str.length(); ++i) {
            int[] tmpstr = new int[26];

            for (int j = i; j >= 0; --j) {
                tmpstr[str.charAt(j) - 'a']++;

                for (int k = 0; k < j; ++k) {
                    int[] chars = new int[26];
                    int x = k;
                    int count = 0;
                    while (count <= i - j) {
                        ++chars[str.charAt(x) - 'a'];
                        ++x;
                        ++count;
                    }
                    boolean flag = true;
                    for (x = 0; x < 26; ++x) {
                        if (tmpstr[x] != chars[x]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) ++total;
                }

            }
        }
        return total;

    }


}
