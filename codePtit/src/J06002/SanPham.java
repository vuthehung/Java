/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06002;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String maLoai, tenSp;
    private int donGiaL1, donGiaL2;
    
    public SanPham(String maLoai, String tenSp, int donGiaL1, int donGiaL2) {
        this.maLoai = maLoai;
        this.tenSp = tenSp;
        this.donGiaL1 = donGiaL1;
        this.donGiaL2 = donGiaL2;
    }
    
    public String getMaLoai() {
        return maLoai;
    }
    public String getTenSp() {
        return tenSp;
    }
    
    public int getDonGiaL1() {
        return donGiaL1;
    }
    
    public int getDonGiaL2() {
        return donGiaL2;
    }
}
