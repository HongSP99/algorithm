import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Student[] arr = new Student[N];

        for(int i = 0 ; i < N ; i++){
            String S = br.readLine();
            StringTokenizer st = new StringTokenizer(S, " ");

            arr[i] = new Student();

            arr[i].name = st.nextToken();
            arr[i].korean = Integer.parseInt(st.nextToken());
            arr[i].english = Integer.parseInt(st.nextToken());
            arr[i].math = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < N ; i++){
            bw.write(arr[i].name + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class Student implements Comparable<Student>{
        String name;
        int korean;
        int english;
        int math;

        @Override
        public int compareTo(Student other) {
            if(other.korean != korean)
                return other.korean - korean;
            if(other.english != english)
                return english - other.english;
            if(other.math != math)
                return other.math - math;
            return name.compareTo(other.name);
        }
    }
}