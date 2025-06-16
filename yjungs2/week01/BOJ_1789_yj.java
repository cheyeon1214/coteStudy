package yjungs2.week01;

import java.util.Scanner;

// BOJ 1789 수들의 합
public class BOJ_1789_yj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong(); // int가 아닌 long 타입
        long ac_num = 0;
        long ans = 0;
        for(int i = 1; i<=s; i++){ // s=1일 때를 놓치면 안 됨
            ac_num += i;
            if(ac_num == s) {
                ans = i;
                break;
            } else if(ac_num > s) {
                ans = i-1;
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}