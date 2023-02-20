/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06004;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> l_sv = new ArrayList<>();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            l_sv.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt()));
            sc.nextLine();
        }
        
        for(int i = 1; i <= m; i++) {
            Nhom.setNhom(i, sc.nextLine());
        }
        
        Collections.sort(l_sv);
        
        for(SinhVien sv : l_sv) {
            System.out.println(sv);
        }
    }
}
