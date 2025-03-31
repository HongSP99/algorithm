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
        Arr[] arr = new Arr[N];

        // 1. Index와 함께 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Arr();

            arr[i].value = Integer.parseInt(st.nextToken());
            arr[i].index = i;
        }

        // 2. A 배열의 값으로 정렬
        Arrays.sort(arr);
        
        // 2. A 배열의 값을 P의 배열의 값으로 변경
        for(int i = 0 ; i < N ; i++){
            arr[i].value = arr[i].index;
            arr[i].index = i;
        }

        // 3. Index 값으로 정렬
        Arrays.sort(arr);


        // 4. P 배열 출력
        for(int i = 0 ; i < N ; i++){
            bw.write(arr[i].index + " ");
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