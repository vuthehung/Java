/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06001;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SanPham> l_sp = new ArrayList<>();
        ArrayList<HoaDon> l_hd = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            l_sp.add(new SanPham(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= m; i++) {
            String ma = sc.next();
            int sl = sc.nextInt();
            for(SanPham sp : l_sp) {
                if(ma.substring(0, 2).equals(sp.getMaLoai())) {
                    l_hd.add(new HoaDon(i, ma, sl, sp));
                }
            }
        }
        for(HoaDon hd : l_hd) {
            System.out.println(hd);
        }
    }
}
