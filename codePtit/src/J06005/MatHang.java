/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06005;

/**
 *
 * @author Admin
 */
public class MatHang {
    private String ma, ten, dvTinh;
    private int giaMua, giaBan;
    
    public MatHang(int i, String ten, String dvTinh, int giaMua, int giaBan) {
        this.ma = "MH" + String.format("%03d", i);
        this.ten = ten;
        this.dvTinh = dvTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }
    
    public String getMa() {
        return ma;
    }
    
    public String getTen() {
        return ten;
    }
    
    public String getDvTinh() {
        return dvTinh;
    }
    
    public int getGiaMua() {
        return giaMua;
    }
    public int getGiaBan() {
        return giaBan;
    }

}
