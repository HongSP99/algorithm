import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int zero = 0;
        int one = 0;

        if(s.charAt(0) == '0')
            zero++;
        else one++;

        for(int i = 1 ; i < s.length() ; i++){
            char c = s.charAt(i);

            if(s.charAt(i-1) != s.charAt(i)) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        if(zero == 0 || one == 0){
            bw.write(0 + "");
        } else {
            if(zero <= one){
                bw.write(zero + "");
            } else {
                bw.write(one + "");
            }
        }

        bw.flush();
        bw.close();
    }
}
