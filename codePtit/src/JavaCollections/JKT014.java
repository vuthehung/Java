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
public class JKT014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            xuLy(a, n);
        }
    }
    public static void xuLy(int a[], int n) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
      
        for(int i = 0; i < n; i++) {
            while(!st.empty() && a[i] >= a[st.peek()]) st.pop();
            if(!st.empty()) res[i] = i - st.peek();
            else res[i] = i + 1;
            st.push(i);
        }
        for(int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
