import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] tops = new int[N];
        int distanceSum = 0;

        for(int i = 0; i < N ; i++){
            tops[i] = Integer.parseInt(br.readLine());
            distanceSum += tops[i];
        }

        int pairIndex = 0;
        int distClockWise = 0;
        int distCounterClockWise = distanceSum;
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            while(distClockWise < distCounterClockWise){
                distClockWise += tops[pairIndex];
                distCounterClockWise -= tops[pairIndex];
                pairIndex = (pairIndex + 1)%N;
            }

            ans = Math.max(ans, distCounterClockWise);
            distClockWise -= tops[i];
            distCounterClockWise += tops[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}
