package codus.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836_cy {
    static int N,M,T;
    static int[][] arr;
    static boolean[][][] v;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken()); //제한시간

        arr = new int[N][M];
        v = new boolean[N][M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = BFS();
        if(count == -1){
            System.out.println("Fail");
        }else{
            System.out.println(count);
        }

    }
    private static int BFS() {
    int dx[] = {0, 0, 1, -1};
    int dy[] = {1, -1, 0, 0};
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, false, 0));
    v[0][0][0] = true;

    while (!q.isEmpty()) {
        Node n = q.poll();
        if (n.count > T) continue;
        if (n.x == M - 1 && n.y == N - 1) return n.count;

        for (int i = 0; i < 4; i++) {
            int x = n.x + dx[i];
            int y = n.y + dy[i];
            if (x >= 0 && x < M && y >= 0 && y < N) {
                if (!n.isGram) {
                    if (arr[y][x] == 0 && !v[y][x][0]) {
                        q.add(new Node(x, y, false, n.count + 1));
                        v[y][x][0] = true;
                    } else if (arr[y][x] == 2 && !v[y][x][0]) {
                        q.add(new Node(x, y, true, n.count + 1));
                        v[y][x][0] = true;
                    }
                } else {
                    if (!v[y][x][1]) {
                        q.add(new Node(x, y, true, n.count + 1));
                        v[y][x][1] = true;
                    }
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
    boolean isGram;
    int count;
    public Node(int x, int y, boolean isGram, int count){
        this.x = x;
        this.y = y;
        this.isGram = isGram;
        this.count = count;
    }
}
