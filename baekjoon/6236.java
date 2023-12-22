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
        int M = Integer.parseInt(st.nextToken());

        int[] moneys = new int[N];

        for(int i = 0 ; i < N ; i++){
            moneys[i] = Integer.parseInt(br.readLine());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(findMinMoney(moneys, M) + "");
        bw.flush();
        bw.close();


    }

    private static boolean isPossible(int[] moneys, int cutMoney, int M){
        int cnt = 1;
        int sum = 0;
        for(int money : moneys){
            sum += money;
            if(sum >= cutMoney){
                cnt++;
                sum = money;
            }
        }
        return cnt <= M;
    }

    private static int findMinMoney(int[] moneys, int M){
        int l = Arrays.stream(moneys).max().getAsInt();
        int r = 1000000000;
        int answer = 0;
        while(l <= r){
            int m = (l+r)/2;
            if(isPossible(moneys, m, M)){
                answer = m;
                r = m-1;
            } else{
                l = m+1;
            }
        }
        return answer;
    }
}
