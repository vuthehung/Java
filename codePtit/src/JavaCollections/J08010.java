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
public class J08010 {
    public static boolean thuanNgich(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> set = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        while(sc.hasNext()) {
            String s = sc.next();
            if(m.containsKey(s)) {
                m.put(s, m.get(s) + 1);
            } else {
                set.add(s);
                m.put(s, 1);
            }
        }
        int max_l = 0;
        ArrayList<String> res = new ArrayList<>();
        for(String x : set) {
            if(thuanNgich(x)) {
                max_l = Math.max(max_l, x.length());
                res.add(x);
            }
        }
        for(String x : res) {
            if(x.length() == max_l) {
                System.out.printf("%s %d\n", x, m.get(x));
                    
            }
        }
    }
}
