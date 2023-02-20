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
class Pair<T1, T2> {
    T1 first;
    T2 second;
    
    Pair() {
        
    }
    Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    
    public void setFirst(T1 first) {
        this.first = first;
    }
    
    public void setSecond(T2 second) {
        this.second = second;
    }
    
    public T1 getFirst() {
        return first;
    }
    
    public T2 getSecond() {
        return second;
    }
}
public class HinhChuNhat {
    public static long func(ArrayList<Long> a, long n) {
        long res = 0;
        Stack<Pair<Long, Long>> st = new Stack<>();
        st.add(new Pair<>(-1L, 0L));
        for(long i = 0; i < n; i++) {
            long x = a.get((int) i);
            if(st.empty() || st.peek().getSecond() <= x) {
                st.add(new Pair<>(i, x));
            }else {
                while(!st.empty() && st.peek().getSecond() > x) {
                    Pair<Long, Long> d = st.pop();
                    res = Math.max(res, d.getSecond() * (i - 1 - st.peek().getFirst()));
                }
                st.add(new Pair<>(i, x));
            }
        }
        while(st.size() > 1) {
            Pair<Long, Long> d = st.pop();
            res = Math.max(res, d.getSecond() * (n - 1 - st.peek().getFirst()));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextInt();
        long n = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        for(int i = 0; i < n; i++) a.add(sc.nextLong());
        long res1 = func(a, n);
        for(int i = 0; i < n; i++) a.set(i, m - a.get(i));
        long res2 = func(a, n);
        System.out.println(Math.max(res1, res2));
    }
}
