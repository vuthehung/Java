package queue;
import java.util.*;
public class GiaTriNhoNhat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while (t-->0){
            int k = in.nextInt();
            String s = in.next();
            
            int[] count = new int[256];
            for (int i=0;i<s.length();i++)  count[s.charAt(i)]++;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> o2-o1);
            
            for (int i=0;i<256;i++) if(count[i]>0) pq.add(count[i]);
            
            while (k-->0){
                int tmp = pq.poll();
                if (tmp >0){
                    tmp--; 
                    pq.add(tmp);
                }
            }
            
            long sum=0;
            while (!pq.isEmpty()){
                int tmp = pq.poll();
                sum = sum + (long)tmp*tmp;
            }
            
            System.out.println(sum);
        }
    }
}