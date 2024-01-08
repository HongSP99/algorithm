import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String rocks_str = br.readLine();
        char[] rocks = rocks_str.toCharArray();


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(twoPointer(rocks, B, W) + "");

        bw.flush();
        bw.close();

    }

    public static int twoPointer(char[] rocks, int B, int W){
        int ans = 0;
        int nextIndex = 0;
        int countBlack = 0;
        int countWhite = 0;

        for(int i = 0 ; i < rocks.length ; i++){
            while(nextIndex < rocks.length){
                if(rocks[nextIndex] == 'B' && countBlack == B) break;
                if(rocks[nextIndex++] == 'W') countWhite++;
                else countBlack++;
            }

            if(countWhite >= W){
                ans = Math.max(ans, nextIndex-i);
            }

            if(rocks[i] == 'W') countWhite--;
            else countBlack--;

        }


        return ans;
    }
}
