
package queue;

import java.util.*;
public class BDN1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            String s1 = in.next();
            xuly(s1);
        }
    }
    public static void xuly(String s1){
        Queue q = new LinkedList<String>();
        q.add("1"); 
        int dem = 0;
        while(!q.isEmpty()){
            String s2 = (String) q.poll();
            if(s2.length() < s1.length()){
                dem++;
                q.add(s2 + "0");
                q.add(s2 + "1");
            }
            if(s1.length() == s2.length() && s2.compareTo(s1) <= 0) dem++;
        }
        System.out.println(dem);
    }
}
