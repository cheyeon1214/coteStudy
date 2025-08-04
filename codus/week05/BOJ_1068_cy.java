package codus.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068_cy {
    static int[] parent;
    static int delete;
    static boolean[] v;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list= new ArrayList[N];
        parent = new int[N]; //부모 배열
        //i번 노드의 부모는 parent[i]
        v = new boolean[N];
        int root = -1;
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>(); //반드시 초기화
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
            if(parent[i] != -1)
                list[parent[i]].add(i);
        }
        
        //지울 노드. 탐색할 때 delete노드 나오면 탐색 no
        delete = Integer.parseInt(br.readLine());
        
        if (delete == root) {
            System.out.println(0);
            return;
        }
        DFS(root, list);
        System.out.println(count);

    }
    private static void DFS(int node, ArrayList<Integer>[] list) {
        v[node] = true;
        if(list[node].size() == 0) {
            count++;
            return ;
        }
        for(int i : list[node]){
            if(i == delete){
                continue;
            }
            
            if(v[i] == false){
                DFS(i, list);
            }
        }
    }
}
