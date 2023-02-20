/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05048;

/**
 *
 * @author Admin
 */
public class MatHang {
    private String ma;
    private int soLN, soLX, donGia, tien, thue;
    
    public MatHang(String ma, int soLN) {
        this.ma = ma;
        this.soLN = soLN;
        this.soLX = soLX();
        this.donGia = donGia();
        this.tien = soLX * donGia;
        this.thue = thue();
    }

    private int soLX() {
        if(this.ma.charAt(0) == 'A') return Math.round(soLN * 0.6f);
        return Math.round(soLN * 0.7f);
    }

    private int donGia() {
        if(this.ma.charAt(4) == 'Y') return 110000;
        return 135000;
    }

    private int thue() {
        if(this.ma.charAt(0) == 'A' && this.ma.charAt(4) == 'Y') {
            return tien / 100 * 8;
        }else if(this.ma.charAt(0) == 'A' && this.ma.charAt(4) == 'N') {
            return tien / 100 * 11;
        }else if(this.ma.charAt(0) == 'B' && this.ma.charAt(4) == 'Y') {
            return tien / 100 * 17;
        }else if(this.ma.charAt(0) == 'B' && this.ma.charAt(4) == 'N') {
            return tien / 100 * 22;
        }
        return 0;   
    }
    
    @Override
    public String toString() {
        return ma + " " + soLN + " " + soLX + " " + donGia + " " + tien + " " + thue;
    }
}
