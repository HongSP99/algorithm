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
        int C =Integer.parseInt(st.nextToken());

        int[] wifi = new int[N];

        for(int i = 0 ; i < N ; i++){
            wifi[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(wifi);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(findMaxDistance(wifi, C) + "");
        bw.flush();
        bw.close();
    }

    static boolean isPossible(int[] wifi, int cutDistance, int C){
        int cnt = 1;
        int first = wifi[0];
        for(int i = 1 ; i < wifi.length ; i++){
            if(wifi[i] - first >= cutDistance){
                cnt++;
                first = wifi[i];
            }
        }
        return cnt >= C;
    }

    static int findMaxDistance(int[] wifi, int C){
        int l = 1;
        int r = 1000000000;
        int answer = 0;

        while(l <= r){
            int m = (l+r) / 2;

            if(isPossible(wifi, m, C)){
                l = m+1;
                answer = m;
            }
            else{
                r = m-1;
            }
        }
        return answer;
    }
}
