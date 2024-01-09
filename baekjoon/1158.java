import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> removePeople = solution(N, K);


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("<");
        for(int i = 0 ; i < removePeople.size()-1 ; i++){
            bw.write(removePeople.get(i) + ", ");
        }
        bw.write(removePeople.get(removePeople.size()-1) + ">");

        bw.flush();
        bw.close();

    }

    public static List<Integer> solution(int N, int K){
        List<Integer> people = new ArrayList<>();
        List<Integer> removePeople = new ArrayList<>();

        for(int i = 1 ; i <= N ; i++){
            people.add(i);
        }

        int removeIndex = 0;

        for(int i = 0 ; i < N ; i++){
            removeIndex = (removeIndex+(K-1))%(N-i);
            removePeople.add(people.get(removeIndex));
            people.remove(removeIndex);
        }

        return removePeople;
    }

}
