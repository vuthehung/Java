/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06007;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MonHoc> l_mh = new ArrayList<>();
        ArrayList<GiangVien> l_gv = new ArrayList<>();
        ArrayList<GioGiangDay> l_g = new ArrayList<>();
        int n = sc.nextInt();
        while(n-- > 0) {
            String ma = sc.next();
            String ten = sc.nextLine().trim();
            l_mh.add(new MonHoc(ma, ten));
        }
        int m = sc.nextInt();
        while(m-- > 0) {
            String ma = sc.next();
            String ten = sc.nextLine().trim();
            l_gv.add(new GiangVien(ma, ten));
        }
        int z = sc.nextInt();
        while(z-- > 0) {
            String maGv = sc.next();
            String maMh = sc.next();
            float gioChuan = sc.nextFloat();
            MonHoc mh = null;
            for(MonHoc tmp : l_mh)
                if(tmp.getMa().equals(maMh))
                    mh = tmp;
            GiangVien gv = null;
            for(GiangVien tmp : l_gv)
                if(tmp.getMa().equals(maGv))
                    gv = tmp;
            GioGiangDay gGD = new GioGiangDay(mh, gv);
            gGD.setGioChuan(gioChuan);
            l_g.add(gGD);
        }
        for(GioGiangDay gGD : l_g) {
            System.out.println(gGD);
        }
    }
}

//2
//INT1155 Tin hoc co so 2
//INT1306 Cau truc du lieu va giai thuat
//2
//GV01 Nguyen Van An
//GV02 Hoang Binh Minh
//3
//GV01 INT1155 113.2
//GV01 INT1306 126.72
//GV02 INT1306 126.72