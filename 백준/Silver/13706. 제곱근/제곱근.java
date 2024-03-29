import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    static BigInteger N, start, end, mid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = new BigInteger(br.readLine());
        start = new BigInteger("1");
        end = N;

        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            int result = (mid.multiply(mid)).compareTo(N);
            if (result == 0) break;
            else if (result == 1) end = mid.subtract(new BigInteger("1"));
            else start = mid.add(new BigInteger("1"));
        }

        bw.write(mid.toString());
        br.close();
        bw.close();
    }
}