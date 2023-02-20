/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05077;

/**
 *
 * @author Admin
 */
public class Luong {
    private String maNV, tenNV, maPB, tenPB, loaiNV;
    private int luongCB, ngayCong, luongThang, heSo, namCongTac;
    private PhongBan pb;
    
    public Luong(String maNV, String tenNV, int luongCB, int ngayCong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luongCB = luongCB;
        this.ngayCong = ngayCong;
        this.loaiNV = maNV.substring(0, 1);
        this.namCongTac = Integer.parseInt(maNV.substring(1, 3));
        this.maPB = maNV.substring(3);
        this.pb = new PhongBan();
        
        tinhHeSo(namCongTac, loaiNV);
        tinhLuongThang(luongCB, ngayCong, heSo);
    }

    private void tinhHeSo(int namCongTac, String loaiNV) {
        switch(loaiNV) {
            case "A":
                if(namCongTac >= 1 && namCongTac <= 3) {
                    this.heSo = 10;
                }else if(namCongTac >= 4 && namCongTac <= 8) {
                    this.heSo = 12;
                }else if(namCongTac >= 9 && namCongTac <= 15) {
                    this.heSo = 14;
                }else {
                    this.heSo = 20;
                }
                break;
            case "B":
                if(namCongTac >= 1 && namCongTac <= 3) {
                    this.heSo = 10;
                }else if(namCongTac >= 4 && namCongTac <= 8) {
                    this.heSo = 11;
                }else if(namCongTac >= 9 && namCongTac <= 15) {
                    this.heSo = 13;
                }else {
                    this.heSo = 26;
                }
                break;
            case "C":
                if(namCongTac >= 1 && namCongTac <= 3) {
                    this.heSo = 9;
                }else if(namCongTac >= 4 && namCongTac <= 8) {
                    this.heSo = 10;
                }else if(namCongTac >= 9 && namCongTac <= 15) {
                    this.heSo = 12;
                }else {
                    this.heSo = 14;
                }
                break;
            case "D":
                if(namCongTac >= 1 && namCongTac <= 3) {
                    this.heSo = 8;
                }else if(namCongTac >= 4 && namCongTac <= 8) {
                    this.heSo = 9;
                }else if(namCongTac >= 9 && namCongTac <= 15) {
                    this.heSo = 11;
                }else {
                    this.heSo = 13;
                }
                break;
        }
    }

    private void tinhLuongThang(int luongCB, int ngayCong, int heSo) {
        this.luongThang = luongCB * 1000 * ngayCong * heSo;
    }
    
    @Override
    public String toString() {
        return maNV + " " + tenNV + " " + pb.getTenPB(maPB) + " " + luongThang;
    }
}
