package yjungs2.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// BOJ 10815 숫자 카드
public class BOJ_10815_yj {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> cards = new HashSet<String>();
		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			cards.add(str[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] str2 = br.readLine().split(" ");
		for(int i=0; i<m; i++) {
			System.out.print(cards.contains(str2[i])?1+" ":0+" ");
    	}
    } 
}