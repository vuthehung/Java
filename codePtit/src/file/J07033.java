/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class SinhVien implements Comparable<SinhVien>{
    private String ma, ten, lop, email;
    
    public SinhVien(String ma, String ten, String lop, String email) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + email;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.ma.compareTo(o.ma);
    }
}

public class J07033 {
    public static String chuanHoa(String s) {
        StringBuilder kq = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            kq.append(Character.toUpperCase(tmp.charAt(0)));
            for(int i = 1; i < tmp.length(); i++) 
                kq.append(tmp.charAt(i));
            kq.append(" ");
        }
        return kq.toString().trim();
    }
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> l = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = chuanHoa(sc.nextLine());
            String lop = sc.nextLine();
            String email = sc.nextLine();
            l.add(new SinhVien(ma, ten, lop, email));
        }
        Collections.sort(l);
        for(SinhVien sv : l) {
            System.out.println(sv);
        }
    }
}
