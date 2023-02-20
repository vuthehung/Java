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
class Pair implements Comparable<Pair>{
    String s;
    int xh;
    
    public Pair(String s, int xh) {
        this.s = s;
        this.xh = xh;
    }
    
    public void tang() {
        xh += 1;
    }

    @Override
    public int compareTo(Pair o) {
        return o.xh - this.xh;
    }
    @Override
    public String toString() {
        return s + " " + xh;
    }
    
}
public class J08011 {
    public static boolean soKGIam(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) > s.charAt(i + 1))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Pair> m = new TreeMap<>();
        while(sc.hasNext()) {
            String s = sc.next();
//            if(s.equals("1")) break;
            if(soKGIam(s)) {
                if(m.containsKey(s)) {
                    m.get(s).tang();
                } else {
                    m.put(s, new Pair(s, 1));
                }
            }
        }
        ArrayList<Pair> a = new ArrayList<>(m.values());
        Collections.sort(a);
        for(Pair p : a) {
            System.out.println(p);
        }
    }
}
