import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] extensions;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        extensions = new String[N];

        for(int i = 0 ; i < N ; i++){
            String[] str = br.readLine().split("\\.");
            extensions[i] = str[1];
        }

        Arrays.sort(extensions);

        int i = 0;
        while (i < N) {
            int count = 1;
            while (i + 1 < N && extensions[i].equals(extensions[i + 1])) {
                count++;
                i++;
            }
            bw.write(extensions[i] + " " + count + "\n");
            i++;
        }

        bw.flush();
        bw.close();
    }
}