/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05035;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();
            String email = sc.nextLine();
            String doanhNghiep = sc.nextLine();
            a.add(new SinhVien(i, ma, ten, lop, email, doanhNghiep));
        }
        Collections.sort(a);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String dn = sc.nextLine();
            for(SinhVien sv : a) {
                if(sv.getDoanhNghiep().equals(dn)) {
                    System.out.println(sv);
                }
            }
        }
    }
}
