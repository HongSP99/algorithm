import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] area;
    static boolean[][] visit;
    static int R, C;
    static int[][] direction = {{1, 0}, {-1, 0}, {0,1}, {0,-1}};
    static int[] answer = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new char[R][C];
        visit = new boolean[R][C];

        for(int i = 0 ; i < R ; i++){
            char[] chs = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; j++){
                area[i][j] = chs[j];
            }
        }

        countSheepAndWolf();

        for(int i = 0 ; i < 2 ; i++){
            bw.write(answer[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void countSheepAndWolf(){
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                if(visit[i][j]) continue;
                if(area[i][j] == '#') continue;
                bfs(i, j);
            }
        }
    }

    private static void bfs(int i, int j){
        int countWolf = 0;
        int countSheep = 0;
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(i, j));
        visit[i][j] = true;

        if(area[i][j] == 'k') countSheep++;
        if(area[i][j] == 'v') countWolf++;

        while(!que.isEmpty()){
            Node newNode = que.poll();

            int x = newNode.x;
            int y = newNode.y;

            for(int k = 0 ; k < 4 ; k++){
                int nx = x + direction[k][0];
                int ny = y + direction[k][1];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(visit[nx][ny]) continue;
                if(area[nx][ny] == '#') continue;

                if(area[nx][ny] == 'k') countSheep++;
                if(area[nx][ny] == 'v') countWolf++;

                que.add(new Node(nx, ny));
                visit[nx][ny] = true;
            }
        }

        if(countWolf < countSheep) answer[0] += countSheep;
        else answer[1] += countWolf;
    }
}

class Node{
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}