/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05017;

/**
 *
 * @author Admin
 */
public class HoaDon implements Comparable<HoaDon>{
    private String maKH, tenKH;
    private int soCu, soMoi, tongTien;
    
    public HoaDon(int i, String tenKH, int soCu, int soMoi) {
        this.maKH = "KH" + String.format("%02d", i);
        this.tenKH = tenKH;
        this.soCu = soCu;
        this.soMoi = soMoi;
        
        tinhTongTien(soCu, soMoi);
    }
    
    @Override
    public int compareTo(HoaDon o) {
        return o.tongTien - this.tongTien;
    }

    private void tinhTongTien(int soCu, int soMoi) {
        int d = soMoi - soCu;
        if(d >= 0 && d <= 50) {
            int tien = d * 100;
            this.tongTien = Math.round(tien * 1.02f);
        }else if(d >= 51 && d <= 100) {
            int tien = 50 * 100 + (d - 50) * 150;
            this.tongTien = Math.round(tien * 1.03f);
        }else {
            int tien = 50 * 100 + 50 * 150 + (d - 50 - 50) * 200;
            this.tongTien = Math.round(tien * 1.05f);
        }
    }
    
    @Override
    public String toString() {
        return maKH + " " + tenKH + " " + tongTien;
    }
}
