import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String cat_talks = br.readLine();

        char[] cat_talk = cat_talks.toCharArray();



        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(translation(cat_talk, N) + "");

        bw.flush();
        bw.close();

    }
    //bba -> b와 a가 모두 포함되어 있다. -> i++을 하려면 앞에 b를 없애야되는데

    static int translation(char[] cat_talk, int N){
        int ans = 0;
        int nextIndex = 0;
        int[] alpha = new int[26];
        for(int i = 0 ; i < cat_talk.length ; i++){
            while(nextIndex < cat_talk.length){
                alpha[cat_talk[nextIndex++] - 'a']++;
                if(getalphaCount(alpha) > N){
                    alpha[cat_talk[--nextIndex] - 'a']--;
                    break;
                }
            }
            ans = Math.max(ans, nextIndex-i);
            alpha[cat_talk[i] - 'a']--;
        }
        return ans;
    }

    static int getalphaCount(int[] alpha){
        int cnt = 0;
        for (int j : alpha) {
            if (j > 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
