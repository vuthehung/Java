/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class LT implements Comparable<LT> {
    String ten;
    int ac, submit;
    
    public LT(String ten, int ac, int submit) {
        this.ten = ten;
        this.ac = ac;
        this.submit = submit;
    }

    @Override
    public int compareTo(LT o) {
        if(this.ac != o.ac)
            return o.ac - this.ac;
        else if(this.submit != o.submit)
            return this.submit - o.submit;
        else
            return this.ten.compareTo(o.ten);
    }
    
    @Override
    public String toString() {
        return ten + " " + ac + " " + submit;
    }
}
public class LuyentapLapTrinh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        ArrayList<LT> a = new ArrayList<>();
        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            sc.nextLine();
            String ten = sc.nextLine();
            int ac = sc.nextInt();
            int submit = sc.nextInt();
            a.add(new LT(ten, ac, submit));
        }
        Collections.sort(a);
        for(LT x : a) {
            System.out.println(x);
        }
    }
}
