import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] visit;
    static int[][] area;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[][] direction = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                int height = Integer.parseInt(st.nextToken());
                min = Math.min(min, height);
                max = Math.max(max, height);
                area[i][j] = height;
            }
        }

        bw.write(maxCountArea() + "");

        bw.flush();
        bw.close();
    }

    private static int maxCountArea(){
        int answer = 1;
        for(int i = min ; i <= max ; i++){
            int count = 0;

            for(int j = 0 ; j < N ; j++){
                Arrays.fill(visit[j], false);
            }

            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < N ; k++){
                    if(visit[j][k]) continue;
                    if(area[j][k] <= i) continue;
                    bfs(j, k , i);
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }

    private static void bfs(int x, int y, int height){
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(x, y));
        visit[x][y] = true;

        while(!que.isEmpty()){
            Node newNode = que.poll();

            int nx = newNode.x;
            int ny = newNode.y;

            for(int i = 0 ; i < 4 ; i++){
                int nnx = nx + direction[i][0];
                int nny = ny + direction[i][1];

                if(nnx < 0 || nny < 0 || nnx >= N || nny >= N) continue;
                if(visit[nnx][nny]) continue;
                if(area[nnx][nny] <= height) continue;

                visit[nnx][nny] = true;
                que.add(new Node(nnx, nny));
            }
        }
    }

}

class Node{
    public int x;
    public int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
