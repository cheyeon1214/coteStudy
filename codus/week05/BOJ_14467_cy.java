package codus.week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14467_cy {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] check = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            check[i] = -1;
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if (check[cow] == -1) {
                check[cow] = position;
            } else if (check[cow] != position){
                total++;
                check[cow] = position;
            }
        }
        System.out.println(total);
    }
}
