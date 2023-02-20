/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.util.*;

/**
 *
 * @author Admin
 */
public class SoNguyenThuy {
    public static String[] res = new String[10001];
    
    public static String rever(String s) {
        String tmp = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return tmp;
    }
    
    public static boolean thuanNgich(String s) {
        String tmp = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            tmp += s.charAt(i);
        }
        return s.equals(tmp);
    }
    public static void taoSo(int n) {
        Queue<String> q = new LinkedList<>();
        int i = 0;
        q.offer("44");
        q.offer("45");
        q.offer("54");
        q.offer("55");
        q.offer("444");
        q.offer("445");
        q.offer("454");
        q.offer("455");
        q.offer("544");
        q.offer("545");
        q.offer("554");
        q.offer("555");
        while(!q.isEmpty()) {
            String s = q.poll();
            if(thuanNgich(s) && s.length() % 2 == 0) {
                System.out.printf(s + " ");
                i++;
            }
            q.offer(s + rever(s));
            if(i == n) break;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            taoSo(n);
        }
    }
}
