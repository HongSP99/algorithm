import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int N;
    static Map<Long, Integer> cards;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cards = new TreeMap<>();

        for(int i = 0 ; i < N ; i++){
            long card = Long.parseLong(br.readLine());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        long maxCard = 0;
        int cardCount = 0;

        for(long card : cards.keySet()){
            if(cards.get(card) > cardCount){
                cardCount = cards.get(card);
                maxCard = card;
            }
        }

        bw.write(maxCard + "");



        bw.flush();
        bw.close();
    }
}