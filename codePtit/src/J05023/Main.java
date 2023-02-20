/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05023;

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
        while(n-- > 0) {
            a.add(new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        } 
        int t = Integer.parseInt(sc.nextLine());
        while(t -- > 0) {
            String x = sc.nextLine();
            String s = x.substring(2);
            System.out.println("DANH SACH SINH VIEN KHOA " + x + ":");
            for(SinhVien sv : a) {
                if(sv.getKhoa().equals(s)) {
                    System.out.println(sv);
                }
            }
        }
        
    }
}
