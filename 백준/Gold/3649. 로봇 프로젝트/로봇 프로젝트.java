import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int x, n;
    static int[] arr;
    static boolean possible;
    static int lego1, lego2;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while ((s = br.readLine()) != null) {
            x = Integer.parseInt(s) * 10000000;
            s = br.readLine();
            n = Integer.parseInt(s);
            arr = new int[n];
            possible = false;
            lego1 = 0;
            lego2 = 0;

            for (int i = 0; i < n; ++i) {
                s = br.readLine();
                arr[i] = Integer.parseInt(s);
            }

            Arrays.sort(arr);

            for (int i = 0; i < n; ++i) {
                int piece1 = i;
                int left = i + 1;
                int right = n - 1;

                while (left <= right) {
                    int piece2 = (left + right) / 2;
                    if (arr[piece1] + arr[piece2] == x) {
                        if (Math.abs(arr[piece1] - arr[piece2]) >= Math.abs(arr[lego1] - arr[lego2])) {
                            possible = true;
                            lego1 = piece1;
                            lego2 = piece2;
                        }
                        break;
                    } else if (arr[piece1] + arr[piece2] < x) {
                        left = piece2 + 1;
                    } else if (arr[piece1] + arr[piece2] > x) {
                        right = piece2 - 1;
                    }
                }
            }

            if (possible) {
                bw.write("yes " + arr[lego1] + " " + arr[lego2] + "\n");
            } else {
                bw.write("danger \n");
            }
            bw.flush();
        }
        bw.close();

    }
}