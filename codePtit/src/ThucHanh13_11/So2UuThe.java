/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.util.*;

/**
 *
 * @author Admin
 */
public class So2UuThe {
    public static boolean check(String s) {
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '2')
                cnt2++;
        }
        return cnt2 > s.length() / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            q.offer("1");
            q.offer("2");       
            int i = 0;
            while(!q.isEmpty()) {
                String s = q.poll();
                if(check(s)) {
                    System.out.printf(s + " ");
                    i++;
                }
                if(i == n) break;
                q.offer(s + "0");
                q.offer(s + "1");
                q.offer(s + "2");
            }
            System.out.println();
        }
    }
}
