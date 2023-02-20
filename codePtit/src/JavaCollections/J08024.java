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
public class J08024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            Queue<String> q = new LinkedList<>();
            q.offer("9");
            while(true) {
                String tmp = q.poll();
                if(Integer.parseInt(tmp) % n == 0) {
                    System.out.println(tmp);
                    break;
                }
                q.offer(tmp + "0");
                q.offer(tmp + "9");
            }
        }
    }
}
