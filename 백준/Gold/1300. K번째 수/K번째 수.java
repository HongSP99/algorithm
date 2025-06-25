import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int l = 1;
        int r = K;

        while(l < r){
            int m = (l+r)/2;
            int cnt = 0;
            for(int i = 1 ; i <= N; i++){
                cnt += Math.min((m/i), N);
            }
            if(cnt >= K){
                r = m;
            } else {
                l = m+1;
            }
        }

        bw.write(r + "");

        bw.flush();
        bw.close();
    }
}
