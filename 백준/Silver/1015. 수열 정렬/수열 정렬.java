import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Arr[] B = new Arr[N];
        int[] P = new int[N];

        // 1. Index와 함께 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            B[i] = new Arr();

            B[i].value = Integer.parseInt(st.nextToken());
            B[i].index = i;
        }

        Arrays.sort(B);

        for(int i = 0 ; i < N ; i++){
            P[B[i].index] = i;
        }

        for(int i = 0 ; i < N ; i++){
            bw.write(P[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Arr implements Comparable<Arr>{
        public int value;
        public int index;


        @Override
        public int compareTo(Arr other) {
            if(other.value != value)
                return value - other.value;
            return index - other.index;
        }
    }
}