/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06008;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Map<String, GiangVien> m1 = new HashMap<>();
        Map<String, MonHoc> m2 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String[] tmp = sc.nextLine().trim().split(" +", 2);
            String ma = tmp[0];
            String ten = tmp[1];
            m2.put(ma, new MonHoc(ma, ten));
        }
        
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String[] tmp = sc.nextLine().trim().split(" +", 2);
            String ma = tmp[0];
            String ten = tmp[1];
            m1.put(ma, new GiangVien(ma, ten));
        }
        
        Map<String, ArrayList<Pair>> m3 = new HashMap<>();
        int k = Integer.parseInt(sc.nextLine());
        while(k-- > 0) {
            String[] tmp = sc.nextLine().trim().split(" ");
            String maGV = tmp[0];
            String maMH = tmp[1];
            float gio = Float.parseFloat(tmp[2]);
            Pair p = new Pair(maMH, gio);
            if(m3.containsKey(maGV)) {
                m3.get(maGV).add(p);
            }else {
                m3.put(maGV, new ArrayList<>(Arrays.asList(p)));
            }
        }
        
        String q = sc.nextLine();
        System.out.println("Giang vien: " + m1.get(q).getTen());
        ArrayList<Pair> res = m3.get(q);
        float tong = 0;
        for(Pair p : res) {
            System.out.println(m2.get(p.getK1()).getTen() + " " + p.getK2());
            tong += p.getK2();
        }
        System.out.println("Tong: " + String.format("%.2f", tong));
    }   
}

//2
//INT1155 Tin hoc co so 2
//INT1306 Cau truc du lieu va giai thuat
//2
//GV01 Nguyen Van An
//GV02 Hoang Binh Minh
//2
//GV01 INT1155 113.2
//GV02 INT1306 126.72
//GV01