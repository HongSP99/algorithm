import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] kettles;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kettles = new long[N];
        for(int i = 0 ; i < N ; i++){
            kettles[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(kettles);

        long ans = 0;
        long l = 1;
        long r = kettles[N-1];

        while(l <= r){
            long m = (l+r)/2;
            long temp = 0;
            for(int i = 0 ; i < N ; i++){
                temp += (kettles[i]/m);
            }

            if(temp < K){
                r = m-1;
            } else{
                ans = m;
                l = m+1;
            }
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
    }
}
