package queue;
import java.util.*;
public class SoNhiPhan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            xuly(n);
        }
    }
    public static void xuly(int n){
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-->0){
            String tmp = q.poll();
            System.out.print(tmp + " ");
            q.add(tmp + "0");
            q.add(tmp + "1");
        }
        System.out.println();
    }
}
