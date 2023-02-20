/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07038;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static String chuanHoa(String s) {
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            res.append(Character.toUpperCase(tmp.charAt(0)));
            for(int i = 1;i < tmp.length(); i++) {
                res.append(tmp.charAt(i));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        Map<String, SinhVien> m1 = new HashMap<>();
        Map<String, DoanhNghiep> m2 = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = chuanHoa(sc.nextLine());
            String lop = sc.nextLine();
            String email = sc.nextLine();
            m1.put(ma, new SinhVien(ma, ten, lop, email));
        }
        sc = new Scanner(new File("DN.in"));
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soL = Integer.parseInt(sc.nextLine());
            m2.put(ma, new DoanhNghiep(ma, ten, soL));
        }
        sc = new Scanner(new File("THUCTAP.in"));
        ArrayList<ThucTap> a = new ArrayList<>();
        int x = Integer.parseInt(sc.nextLine());
        while(x-- > 0) {
            String[] tmp = sc.nextLine().split(" ");
            String maSv = tmp[0];
            String maDn = tmp[1];
            SinhVien sv = m1.get(maSv);
            DoanhNghiep dn = m2.get(maDn);
            a.add(new ThucTap(sv, dn));
        }
        Collections.sort(a);
        int y = Integer.parseInt(sc.nextLine());
        while(y-- > 0) {
            String maDn = sc.nextLine();
            System.out.println("DANH SACH THUC TAP TAI " + m2.get(maDn).getTen() + ":");
            ArrayList<ThucTap> b = new ArrayList<>();
            for(ThucTap tt : a) {
                if(tt.getDn().getMa().equals(maDn)) {
                    b.add(tt);
                }
            }
            for(int i = 0; i < Math.min(m2.get(maDn).getSoL(), b.size()); i++) {
                System.out.println(b.get(i));
            }
        }
    }
}
