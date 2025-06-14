import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] UserCards = new int[N];

        for(int i = 0 ; i < N ; i++){
            UserCards[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        Arrays.sort(UserCards);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(M-- > 0){
            int x = sc.nextInt();
            int LowerBoundIndex = findLowerBoundIndex(UserCards, x);
            int UpperBoundIndex = findUpperBoundIndex(UserCards, x);
            bw.write(UpperBoundIndex-LowerBoundIndex + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    private static int findLowerBoundIndex(int[] arr, int x){
        int lowerBoundIndex = arr.length;
        int l = 0;
        int r = arr.length-1;

        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] < x) l = m+1;
            else{
                r = m-1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    private static int findUpperBoundIndex(int[] arr, int x){
        int UpperBoundIndex = arr.length;
        int l = 0;
        int r = arr.length-1;

        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] <= x) l = m+1;
            else{
                r = m-1;
                UpperBoundIndex = m;
            }
        }
        return UpperBoundIndex;
    }
}