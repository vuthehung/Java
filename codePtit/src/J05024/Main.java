/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05024;

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
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String s1 = sc.nextLine();
            String s = "";
            switch(s1) {
                case "Ke toan":
                    s = "DCKT";
                    break;
                case "Cong nghe thong tin":
                    s = "DCCN";
                    break;
                case "An toan thong tin":
                    s = "DCAT";
                    break;
                case "Vien thong":
                    s = "DCVT";
                    break;
                case "Dien tu":
                    s = "DCDT";
                    break;
            }
            System.out.println("DANH SACH SINH VIEN NGANH " + s1.toUpperCase() + ":");
            for(SinhVien sv : a) {
                if(s.equals("DCCN") || s.equals("DCAT")) {
                    if(!sv.getLop().startsWith("E")) {
                        if(sv.getMa().contains(s)) {
                            System.out.println(sv);
                        }
                    }
                }else {
                    if(sv.getMa().contains(s)) {
                        System.out.println(sv);
                    }
                }
            }
        }
    }
}
//4
//B16DCCN011
//Nguyen Trong Duc Anh
//D16CNPM1
//sv1@stu.ptit.edu.vn
//B15DCCN215
//To Ngoc Hieu
//D15CNPM3
//sv2@stu.ptit.edu.vn
//B15DCKT150
//Nguyen Ngoc Son
//D15CQKT02-B
//sv3@stu.ptit.edu.vn
//B15DCKT199
//Nguyen Trong Tung
//D15CQKT02-B
//sv4@stu.ptit.edu.vn
//1
//Ke toan