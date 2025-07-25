package codus.week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_cy {
    static int M, N;
    static boolean[][] v;
    static int[][] arr;
    static int t_count; //총 토마토 수
    static int m_count; //내 토마토 수 
    static Queue<Tomato> tomatos = new LinkedList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] != -1) {
                     t_count++;
                }

                if(arr[i][j] == 1) {
                    tomatos.add(new Tomato(j, i));
                    m_count++;
                }
            }
        }

        int time = BFS();

        System.out.println(time);

    }

    static int BFS(){
        int time=0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while(!tomatos.isEmpty()){
            
            int size = tomatos.size();
            if(m_count == t_count) return time;
            if(tomatos.size() == 0) break;
            time++;
            for(int i=0; i<size; i++){
                
                Tomato t = tomatos.poll();
                for(int k=0; k<4; k++){
                    int x = dx[k]+t.x;
                    int y = dy[k]+t.y;
                    if(x>=0 && x<M && y>=0 && y<N){
                        if(arr[y][x] == 0){//안익었다면 
                            arr[y][x] = 1;
                            tomatos.add(new Tomato(x,y));
                            m_count++;
                        }
                    }
                }
            }
        }

        
        
        return -1;
    }
}

class Tomato{
    int x; 
    int y;
    public Tomato(int x,int y){
        this.x = x;
        this.y = y;
    }
}
