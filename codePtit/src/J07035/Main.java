/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07035;

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
            for(int i = 1; i < tmp.length(); i++) {
                res.append(tmp.charAt(i));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, SinhVien> m1 = new HashMap<>();
        Map<String, MonHoc> m2 = new HashMap<>();
        
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = chuanHoa(sc.nextLine());
            String lop = sc.nextLine();
            String email = sc.nextLine();
            SinhVien sv = new SinhVien(ma, ten, lop, email);
            m1.put(ma, sv);
        }
        sc = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            int soTC = Integer.parseInt(sc.nextLine());
            m2.put(ma, new MonHoc(ma, ten, soTC));
        }
        sc = new Scanner(new File("BANGDIEM.in"));
        ArrayList<BangDiem> a = new ArrayList<>();
        int x = Integer.parseInt(sc.nextLine());
        while(x-- > 0) {
            String tmp = sc.nextLine();
            String[] s = tmp.split(" ");
            String maSV = s[0];
            String maMH = s[1];
            float diem = Float.parseFloat(s[2]);
            SinhVien sv = m1.get(maSV);
            MonHoc mh = m2.get(maMH);
            a.add(new BangDiem(sv, mh, diem));
        }
        Collections.sort(a);
        int y = Integer.parseInt(sc.nextLine());
        while(y-- > 0) {
            String maM = sc.nextLine();
            System.out.println("BANG DIEM MON " + m2.get(maM).getTen() + ":");
            for(BangDiem bd : a) {
                if(bd.getMH().getMa().equals(maM)) {
                    System.out.println(bd);
                }
            }
        }
    }
}
