import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cables = new int[K];

        for(int i = 0 ; i < K ; i++){
            cables[i] = Integer.parseInt(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(findMaxLength(cables, N) + "");
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int[] cables, long length, int enoughCount){
        long sum = 0;
        for(int cable : cables){
            if(cable >= length) sum += cable/length;
        }
        return sum >= enoughCount;
    }

    private static long findMaxLength(int[] cables, int enoughCount){
        long l = 1;
        long r = Integer.MAX_VALUE;
        long answer = -1;

        while(l <= r){
            long m = (l+r)/2;
            if(isPossible(cables, m, enoughCount)){
                answer = m;
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return answer;
    }
}
