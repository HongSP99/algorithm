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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(findEnoughHeight(trees, M) + "");
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    static boolean isEnough(int[] trees, int Height, int enoughHeight){
        long sum = 0;
        for(int h : trees){
            if(h > Height) sum += h - Height;
        }
        return sum >= enoughHeight;
    }

    static int findEnoughHeight(int[] trees, int M){
        int l = 0;
        int r = 1000000000;
        int enoughHeight = -1;

        while(l <= r){
            int m = (l+r)/2;
            if(isEnough(trees, m, M)){
                l = m+1;
                enoughHeight = m;
            }
            else{
                r = m-1;
            }
        }
        return enoughHeight;
    }


}