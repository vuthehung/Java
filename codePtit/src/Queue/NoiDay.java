package queue;
import java.util.*;
public class NoiDay {
    public static void main(String[] args) {
        long mod = (long) (10e8 + 7);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(in.nextLong());
            } 
            long sum = 0;
            while (pq.size() > 1) {
                long min1 = pq.poll(), min2 = pq.poll();
                long x = (min1 + min2) % mod;
                pq.add(x);
                sum = (sum + x) % mod;
            }
            System.out.println(sum);
        }
    }
}