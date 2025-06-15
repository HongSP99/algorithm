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
    static int[] solution;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solution = new int[N];
        String[] arr = br.readLine().split(" ");

        for(int i = 0 ; i < N ; i++){
            solution[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(solution);

        int[] ans = new int[2];
        ans[0] = solution[0];
        ans[1] = solution[N-1];

        int l = 0;
        int r = N-1;

        while(l < r){
            int temp = solution[l] + solution[r];
            int tempAns = ans[0] + ans[1];

            if(Math.abs(temp) < Math.abs(tempAns)){
                ans[0] = solution[l];
                ans[1] = solution[r];
            }

            if(temp < 0){
                l++;
            } else if(temp > 0){
                r--;
            } else {
                break;
            }
        }

        bw.write(ans[0] + " " + ans[1] + "");

        bw.flush();
        bw.close();
    }
}