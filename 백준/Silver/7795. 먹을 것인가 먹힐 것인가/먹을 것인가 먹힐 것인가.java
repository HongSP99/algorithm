import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            String[] arr = br.readLine().split(" ");
            N = Integer.parseInt(arr[0]);
            M = Integer.parseInt(arr[1]);

            A = new int[N];
            B = new int[M];

            String[] A_arr = br.readLine().split(" ");
            for(int j = 0 ; j < N ; j++){
                A[j] = Integer.parseInt(A_arr[j]);
            }

            String[] B_arr = br.readLine().split(" ");
            for(int j = 0 ; j < M ; j++){
                B[j] = Integer.parseInt(B_arr[j]);
            }

            Arrays.sort(B);

            int ans = 0;
            for(int j = 0 ; j < N ; j++){
                int l = 0, r = M-1;
                int result = Integer.MAX_VALUE;
                int X = A[j];
                while(l <= r){
                    int m = (l+r)/2;
                    if(X > B[m]){
                        result = m;
                        l = m+1;
                    } else {
                        r = m-1;
                    }
                }
                if(result != Integer.MAX_VALUE){
                    ans += result+1;
                }
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        bw.close();
    }
}