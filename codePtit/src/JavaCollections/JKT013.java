/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCollections;

import java.util.*;

/**
 *
 * @author Admin
 */
public class JKT013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            ArrayList<String> a = new ArrayList<>();
            q.offer("6");
            q.offer("8");
            while(true) {
                String tmp = q.poll();
                if(tmp.length() > n) break;
                a.add(tmp);
                q.offer(tmp + "6");
                q.offer(tmp + "8");
            }
            Collections.reverse(a);
            System.out.println(a.size());
            for(String s : a) 
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
