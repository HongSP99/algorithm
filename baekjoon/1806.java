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
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(twoPointer(arr, S) + "");
        bw.flush();
        bw.close();


    }

    private static int twoPointer(int[] arr, int S){
        int minLength = Integer.MAX_VALUE;
        int ans = 0;
        int index = 1;
        int rightIndex = 0;
        int currentSum = arr[0];

        for(int i = 0 ; i < arr.length ; i++){
            while(currentSum < S && rightIndex < arr.length-1){
                currentSum += arr[++rightIndex];
                index++;
            }
            if(currentSum >= S){
                ans++;
                if(minLength > index)
                    minLength = index;
            }
            currentSum -= arr[i];
            index--;
        }

        if(ans == 0){
            return 0;
        } else{
            return minLength;
        }
    }
}
