/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05038;

/**
 *
 * @author Admin
 */
public class Luong {
    private String maNV, tenNV, chucVu;
    private int luongNgay, ngayCong, luongThang, thuong, phuCapChucVu, thucLinh;
    
    public Luong(int i, String tenNV, int luongNgay, int ngayCong, String chucVu) {
        this.maNV = "NV" + String.format("%02d", i);
        this.tenNV = tenNV;
        this.luongNgay = luongNgay;
        this.ngayCong = ngayCong;
        this.chucVu = chucVu;
        
        this.luongThang = luongNgay * ngayCong;
        
        tinhThuong(luongThang, ngayCong);
        
        tinhPhuCap(chucVu);
        
        this.thucLinh = luongThang  + thuong + phuCapChucVu;
    }

    private void tinhThuong(int luongThang, int ngayCong) {
        if(ngayCong >= 25) {
            this.thuong = (int) (0.2 * luongThang);
        }else if(ngayCong >= 22) {
            this.thuong = (int) (0.1 * luongThang);
        }else {
            this.thuong = 0;
        }
    }

    private void tinhPhuCap(String chucVu) {
        switch (chucVu) {
            case "GD":
                this.phuCapChucVu = 250000;
                break;
            case "PGD":
                this.phuCapChucVu = 200000;
                break;
            case "TP":
                this.phuCapChucVu = 180000;
                break;
            default:
                this.phuCapChucVu = 150000;
                break;
        }
    }
    
    public int getThucLinh() {
        return thucLinh;
    }
    
    @Override
    public String toString() {
        return maNV + " " + tenNV + " " + luongThang + " " + thuong + " " + phuCapChucVu + " " + thucLinh;
    }
}
