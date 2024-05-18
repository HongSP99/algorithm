import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] area;
    static boolean[][] visit;
    static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        area = new int[M][N];
        visit = new boolean[M][N];

        for(int i = 0 ; i < M ; i++){
            Arrays.fill(area[i], 0);
        }

        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1 ; k < y2 ; k++){
                    area[k][j] = 1;
                }
            }
        }

//        for(int i = 0 ; i < M ; i++){
//            for(int j = 0 ; j < N ; j++){
//                bw.write(area[i][j] + " ");
//            }
//            bw.write("\n");
//        }

        List<Integer> answer = solution();
        Collections.sort(answer);

        bw.write(answer.size() + "\n");

        for(int i = 0 ; i < answer.size() ; i++){
            bw.write(answer.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }

    private static List<Integer> solution(){
        List<Integer> answer = new ArrayList<>();

        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(area[i][j] == 0 && !visit[i][j]){
                    answer.add(bfs(i, j));
                }
            }
        }

        return answer;
    }

    private static int bfs(int i , int j){
        int count = 0;
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(j, i));

        while(!que.isEmpty()){
            Node newNode = que.poll();

            int x = newNode.x;
            int y = newNode.y;

            for(int k = 0 ; k < 4 ; k++){
                int nx = x + direction[k][0];
                int ny = y + direction[k][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(area[ny][nx] == 1) continue;
                if(visit[ny][nx]) continue;

                count++;
                que.add(new Node(nx, ny));
                visit[ny][nx] = true;
            }
        }

        if(count == 0){
            return 1;
        } else {
            return count;
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}