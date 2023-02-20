/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05066;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String data = sc.nextLine();
            String chucVu = data.substring(0, 2);
            String soHieu = data.substring(4, 7);
            if(chucVu.equals("GD") && Integer.parseInt(soHieu) < 2) {
                a.add(new NhanVien(data));
            }else if(chucVu.equals("TP") && Integer.parseInt(soHieu) < 4) {
                a.add(new NhanVien(data));
            }else if(chucVu.equals("PP") && Integer.parseInt(soHieu) < 4) {
                a.add(new NhanVien(data));
            }else {
                NhanVien nv = new NhanVien(data);
                nv.setChucVu("NV");
                a.add(nv);
                
            }
        }
        Collections.sort(a);
        int m = Integer.parseInt(sc.nextLine());
        
        while(m-- > 0) {
            String q = sc.nextLine().toLowerCase();
            for(NhanVien nv : a) {
                if(nv.getTen().contains(q)) {
                    System.out.println(nv);
                }
            }
            System.out.println();
        }
    }
}

//6
//GD08001 Nguyen Kim Loan
//TP05002 Hoang Thanh Tuan
//TP05001 Tran Binh Nguyen
//PP06002 Phan Trung Tuan
//PP06001 Tran Quoc Huy
//NV04003 Vo Van Lan
//2
//OA
//aN