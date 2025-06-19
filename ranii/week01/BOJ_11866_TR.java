package ranii.week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11866_TR {
   public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb= new StringBuilder();
        Deque<Integer> dq= new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String text=st.nextToken();
            switch (text) {
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekFirst()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "back":
                    if(!dq.isEmpty()){
                        sb.append(dq.peekLast()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "pop_front":
                    if(!dq.isEmpty()){
                        sb.append(dq.removeFirst()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "pop_back":
                    if(!dq.isEmpty()){
                        sb.append(dq.removeLast()+"\n");
                    }else{
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()+"\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
   }
}
