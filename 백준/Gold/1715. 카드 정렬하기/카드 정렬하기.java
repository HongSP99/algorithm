import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<Integer> cards;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        cards = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++){
            cards.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        if(cards.size() == 1){
            bw.write(0 + "");
        } else {
            while(cards.size() > 1){
                int card1 = cards.poll();
                int card2 = cards.poll();

                int temp = card1 + card2;

                answer += temp;

                cards.add(temp);
            }
            bw.write(answer + "");
        }


        bw.flush();
        bw.close();
    }
}