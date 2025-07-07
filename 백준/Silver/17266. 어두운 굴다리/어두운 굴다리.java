import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(x, N) + "");

        bw.flush();
        bw.close();
    }

    public static int solution(int[] x, int N){
        int answer = 0;
        int l = x[0];
        int r = N;
        while(l <= r){
            int m = (l+r)/2;
            int temp = 0;
            for(int i = 0 ; i < x.length ; i++){
                int start = x[i] - m;
                int end = x[i] + m;
                if(temp < start){
                    break;
                } else {
                    temp = end;
                }
            }
            if(N <= temp){
                answer = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return answer;
    }
}