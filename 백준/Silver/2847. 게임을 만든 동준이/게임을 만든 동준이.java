import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int[] scores;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        scores = new int[N];

        for(int i = 0 ; i < N ; i++){
            scores[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N-2 ; i >= 0 ; i--){
            if(scores[i] >= scores[i+1]){
                answer += scores[i] - (scores[i+1]-1);
                scores[i] = scores[i+1] - 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
