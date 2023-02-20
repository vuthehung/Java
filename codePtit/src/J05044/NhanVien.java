/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05044;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String ma, ten, cV;
    private int phuC, luongThang, tamUng, tongLuong;
    
    public NhanVien(int i, String ten, String cV, int luongCB, int ngayC) {
        this.ma = "NV" + String.format("%02d", i);
        this.ten = ten;
        this.cV = cV;
        
        phuCap();
        this.luongThang = luongCB * ngayC;
        this.tamUng = (phuC + luongThang) * 2/3f < 25000 ? Math.round((phuC + luongThang) * 2 / 3000f) * 1000 : 25000;
        this.tongLuong = luongThang + phuC - tamUng;
    }

    private void phuCap() {
        switch(this.cV) {
            case "GD":
                this.phuC = 500;
                break;
            case "PGD":
                this.phuC = 400;
                break;
            case "TP":
                this.phuC = 300;
                break;
            case "KT":
                this.phuC = 250;
                break;
            default: 
                this.phuC = 100;
                
        }
    }

//    private void tamUng() {
//        if((this.phuC + this.luongThang) * 2 / 3 < 25000) {
//            this.tamUng = Math.round((this.phuC + this.luongThang) * 2 / 3);
//        }else {
//            this.tamUng = 25000;
//        }
//    }
    
    public String getCV() {
        return cV;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + phuC + " " + luongThang + " " + tamUng + " " + tongLuong;
    }
}
