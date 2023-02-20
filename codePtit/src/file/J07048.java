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
class SanPham {
    String maSp, tenSp;
    int giaBan, baoHanh;
    
    void input(Scanner sc) {
        sc.nextLine();
        maSp = sc.nextLine();
        tenSp = sc.nextLine();
        giaBan = sc.nextInt();
        baoHanh = sc.nextInt();
    }
    void output() {
        System.out.println(maSp + " " + tenSp + " " + giaBan + " " + baoHanh);
    }
}
public class J07048 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = sc.nextInt();
        ArrayList<SanPham> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            SanPham dn = new SanPham();
            dn.input(sc);
            a.add(dn);
        }
        Collections.sort(a, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham o1, SanPham o2) {
                if(o1.giaBan != o2.giaBan)
                    return o2.giaBan - o1.giaBan;
                return o1.maSp.compareTo(o2.maSp);
            }
        });
        for(SanPham x : a) {
            x.output();
        }
    }
}
