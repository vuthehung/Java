/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06003;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> l_sv = new ArrayList<>();
        ArrayList<Nhom> l_n = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            l_sv.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        }
        for (int i = 1; i <= m; i++) {
            ArrayList<SinhVien> sv_nhom = new ArrayList<>();
            for (SinhVien sv : l_sv) {
                if (sv.getSttNhom() == i) {
                    sv_nhom.add(sv);
                }
            }
            l_n.add(new Nhom(i, sv_nhom, sc.nextLine()));
        }
        int q = sc.nextInt();
        while (q-- > 0) {
            int nhom = sc.nextInt();
            System.out.println("DANH SACH NHOM " + nhom + ":");
            for (Nhom x : l_n) {
                if (x.getSttNhom() == nhom) {
                    for (Object sv : x.getDsSV()) {
                        System.out.println(sv);
                    }
                    System.out.println("Bai tap dang ky: " + x.getNoiDungBTL());
                }
            }
        }
    }
}
