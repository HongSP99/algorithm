import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        String[] palindromes = new String[T];

        for(int i = 0 ; i < T ; i++){
            palindromes[i] = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String palindrome : palindromes) {
            char[] palin = palindrome.toCharArray();
            bw.write(twoPointer(palin) + "");
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    public static int twoPointer(char[] palin){
        int ans = 0;
        int l = 0;
        int r = palin.length -1;

        while(l<=r){
            if(palin[l] != palin[r]){
                if(isPalindrom(palin, l+1, r) || isPalindrom(palin, l, r-1)) ans = 1;
                else ans = 2;
                break;
            }
            l++;
            r--;
        }

        return ans;
    }

    public static boolean isPalindrom(char[] palin, int l, int r){
        while(l <= r){
            if(palin[l] != palin[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
