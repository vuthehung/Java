/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06001;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    private SanPham sp;
    private int soLuongMua; 
    private long thanhTien, soTienGiam, soTienTra;
    
    public HoaDon(int i, String ma, int soLuongMua, SanPham sp) {
        this.maHD = ma + "-" + String.format("%03d", i);
        this.soLuongMua = soLuongMua;
        this.sp = sp;
        if(maHD.charAt(2) == '1') {
            this.thanhTien = soLuongMua * sp.getDonGiaL1();
        }else {
            this.thanhTien = soLuongMua * sp.getDonGiaL2();
        }
        if(soLuongMua >= 150) {
            this.soTienGiam = thanhTien / 2;
        } else if(soLuongMua >= 100) {
            this.soTienGiam = thanhTien * 3 / 10;
        } else if(soLuongMua >= 50) {
            this.soTienGiam = thanhTien * 15 / 100;
        } else {
            this.soTienGiam = 0;
        }
        this.soTienTra = thanhTien - soTienGiam;
    }
    
    @Override
    public String toString() {
        return maHD + " " + sp.getTenSp() + " " + soTienGiam + " " + soTienTra;
    }
}
