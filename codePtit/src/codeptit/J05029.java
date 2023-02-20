/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;

class DN implements Comparable<DN> {
    private String ma, ten;
    private int sl;
    
    public DN(String ma, String ten, int sl) {
        this.ma = ma;
        this.ten = ten;
        this.sl = sl;
    }
    
    public int getSl() {
        return sl;
    }

    @Override
    public int compareTo(DN o) {
        if(this.sl != o.sl)
            return o.sl - this.sl;
        return this.ma.compareTo(o.ma);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + sl;
    }
    
}
public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DN> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            a.add(new DN(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        Collections.sort(a);
        int q = Integer.parseInt(sc.nextLine());
        while(q-- > 0) {
            ArrayList<DN> res = new ArrayList<>();
            int r = Integer.parseInt(sc.next());
            int l = Integer.parseInt(sc.next());
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU" + r + " DEN " + l + " SINH VIEN:");
            for(DN dn : a) {
                if(dn.getSl() >= r && dn.getSl() <= l) {
                    System.out.println(dn);
                }
            }
        }
        
    }
}
