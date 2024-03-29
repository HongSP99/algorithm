import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int left, right;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        left=0;
        right=-1;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        while(left<=right) {
            int mid = (left+right)/2;
            long budget =0;
            for(int i=0; i<n; i++) {
                if(arr[i]>mid) budget += mid;
                else budget+= arr[i];
            }
            if(budget<=m) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        bw.write(right + "");
        bw.flush();
        bw.close();
    }
}