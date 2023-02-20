/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.util.*;

class Pair implements Comparable<Pair>{
    private String s;
    private int tanSuat;
    
    Pair(String s, int tanSuat) {
        this.s = s;
        this.tanSuat = tanSuat;
    }
    public void tang() {
        this.tanSuat += 1;
    }
    @Override
    public int compareTo(Pair o) {
        return o.tanSuat - this.tanSuat;
    }
    public String getS() {
        return s;
    }
    public int getTuanSuat() {
        return tanSuat;
    }
}
public class SapXep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            Map<String, Pair> m = new LinkedHashMap<>();
            int n = sc.nextInt();
            while(n-- > 0) {
                String tmp = sc.next();
                if(m.containsKey(tmp)) {
                    m.get(tmp).tang();
                }else {
                    m.put(tmp, new Pair(tmp, 1));
                }
            }
            ArrayList<Pair> a = new ArrayList<>(m.values());
            Collections.sort(a);
            for(Pair p : a) {
                for(int i = 0; i < p.getTuanSuat(); i++) {
                    System.out.printf(p.getS() + " ");
                }
            }
            System.out.println();
        } 
    }
}
