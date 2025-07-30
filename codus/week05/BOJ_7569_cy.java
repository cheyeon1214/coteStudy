package codus.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_cy {
    static int[][][] arr;
    static int M, N, H;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로 길이 (x)
        N = Integer.parseInt(st.nextToken()); //세로 길이 (y)
        H = Integer.parseInt(st.nextToken()); //높이 (z)

        arr = new int[H][N][M];

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    arr[z][y][x] = Integer.parseInt(st.nextToken());
                    if (arr[z][y][x] == 1) {
                        q.add(new Node(x, y, z));
                    }
                }
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    static int BFS() {
        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {1, -1, 0, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node t = q.poll();

                for (int k = 0; k < 6; k++) {
                    int nx = t.x + dx[k];
                    int ny = t.y + dy[k];
                    int nz = t.z + dz[k];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                        if (arr[nz][ny][nx] == 0) {
                            arr[nz][ny][nx] = 1;
                            q.add(new Node(nx, ny, nz));
                        }
                    }
                }
            }
            if (!q.isEmpty()) time++;
        }

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (arr[z][y][x] == 0) return -1;
                }
            }
        }

        return time;
    }
}

class Node {
    int x, y, z;
    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}