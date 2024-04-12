import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] dist = new int[200000];
    static int[] parent = new int[200000];
    static int[] direction = {2, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);

        bfs();

        bw.write(dist[K] + "");

        bw.flush();
        bw.close();
    }

    private static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        que.add(N);
        dist[N] = 0;

        while(!que.isEmpty()){
            int x = que.poll();

            if(x == K) return;

            for(int i = 0 ; i < 3 ; i++){
                int nx;
                int direct = direction[i];
                if(direct == 2){
                    nx = x * direct;
                } else {
                    nx = x + direct;
                }

                if(nx < 0 || nx >= dist.length) continue;
                if(dist[nx] != -1) continue;

                if(direct == 2){
                    dist[nx] = dist[x];
                } else {
                    dist[nx] = dist[x] + 1;
                }

                que.add(nx);
                parent[nx] = x;
            }
        }
    }
}