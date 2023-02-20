package queue;
import java.util.*;
public class BiendoiST {
    public static int biendoi(int s, int t){
        if(s >= t)  return  s - t;
        Queue <Integer> q = new LinkedList<>();
        int a[] = new int[20001];
        q.offer(s);
        while(a[t] == 0){
            int top = q.poll();
            if(top - 1 > 0 && a[top - 1] == 0){
                a[top - 1] = a[top] + 1;
                q.offer(top - 1);
            }
            if(top * 2 < 20000 && a[top * 2] == 0){
                a[top * 2] = a[top] + 1;
                q.offer(top * 2);
            }
        }
        return a[t];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            System.out.println(biendoi(sc.nextInt(), sc.nextInt()));
        }
    }
    
}

