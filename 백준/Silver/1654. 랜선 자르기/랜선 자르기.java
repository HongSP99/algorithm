import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new long[K];

        for(int i = 0 ; i < K ; i++){
            lines[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(lines);

        long ans = 0;
        long l = 1;
        long r = lines[K-1];

        while(l <= r){
            long m = (l+r)/2;
            long tempN = 0;
            for(int i = 0 ; i < K ; i++){
                long temp = lines[i]/m;
                tempN += temp;
            }

            if(tempN < N){
                r = m-1;
            } else if(tempN >= N){
                ans = m;
                l = m+1;
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
