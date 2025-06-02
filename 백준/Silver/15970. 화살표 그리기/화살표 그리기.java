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
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int result = 0;
        for(int i = 0 ; i < N ; i++){
            if(i == 0 && arr[i][1] == arr[i+1][1]){
                result += arr[i+1][0] - arr[i][0];
            } else if(i == N-1 && arr[i][1] == arr[i-1][1]){
                result += arr[i][0] - arr[i-1][0];
            } else {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if(arr[i][1] == arr[i-1][1]){
                    left = arr[i][0] - arr[i-1][0];
                }
                if(arr[i][1] == arr[i+1][1]){
                    right = arr[i+1][0] - arr[i][0];
                }
                int temp = Math.min(left, right);
                if(temp != Integer.MAX_VALUE){
                    result += temp;
                }
            }
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}