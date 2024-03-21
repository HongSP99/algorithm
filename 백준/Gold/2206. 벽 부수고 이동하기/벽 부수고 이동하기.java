import java.awt.Desktop;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] area;
    static int[][][] dist;
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new char[N][M];
        dist = new int[N][M][2];

        for(int i = 0 ; i <N ; i++){
            for(int j = 0 ; j < M ; j++){
                Arrays.fill(dist[i][j], -1);
            }
        }

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                area[i][j] = str.charAt(j);
            }
        }

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
    }

    private static int bfs(){
        Queue<Node> que = new LinkedList<>();

        que.add(new Node(0, 0, false));
        dist[0][0][0] = 1;

        while(!que.isEmpty()){
            Node newNode = que.poll();

            int x = newNode.x;
            int y = newNode.y;

            if(newNode.x == N-1 && newNode.y == M-1){
                if(newNode.destroy){
                    return dist[x][y][1];
                } else {
                    return dist[x][y][0];
                }
            }

            for(int i = 0 ; i < 4 ; i++){
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(area[nx][ny] == '0'){
                    if(!newNode.destroy && dist[nx][ny][0] == -1){
                        que.add(new Node(nx, ny, false));
                        dist[nx][ny][0] = dist[x][y][0] + 1;
                    } else if(newNode.destroy && dist[nx][ny][1] == -1){
                        que.add(new Node(nx, ny, true));
                        dist[nx][ny][1] = dist[x][y][1] + 1;
                    }
                } else if(area[nx][ny] == '1'){
                    if(!newNode.destroy){
                        que.add(new Node(nx, ny, true));
                        dist[nx][ny][1] = dist[x][y][0] + 1;
                    }
                }
            }
        }
        return -1;
    }
}

class Node{
    int x;
    int y;
    boolean destroy;

    public Node(int x, int y, boolean destroy) {
        this.x = x;
        this.y = y;
        this.destroy = destroy;
    }
}