/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06005;

import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> l_kh = new ArrayList<>();
        ArrayList<MatHang> l_mh = new ArrayList<>();
        ArrayList<HoaDon> l_hd = new ArrayList<>();
        
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String gt = sc.nextLine();
            String ns = sc.nextLine();
            String dc = sc.nextLine();
            l_kh.add(new KhachHang(i, ten, gt, ns, dc));
        }
        
        int m = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= m; i++) {
            String ten = sc.nextLine();
            String dvTinh = sc.nextLine();
            int giaMua = Integer.parseInt(sc.nextLine());
            int giaBan = Integer.parseInt(sc.nextLine());
            l_mh.add(new MatHang(i, ten, dvTinh, giaMua, giaBan));
        }
        
        int z = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= z; i++) {
            String maKh = sc.next();
            String maMh = sc.next();
            int soLuong = sc.nextInt();
            KhachHang kh = l_kh.get(Integer.parseInt(maKh.substring(2)) - 1);
            MatHang mh = l_mh.get(Integer.parseInt(maMh.substring(2)) - 1);
            l_hd.add(new HoaDon(i, kh, mh, soLuong));
        }
        
        for(HoaDon hd : l_hd) {
            System.out.println(hd);
        }
    }
}
