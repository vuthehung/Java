/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05081;

/**
 *
 * @author Admin
 */
public class MatHang implements Comparable<MatHang>{
    private String ma, ten, dvTinh;
    private int giaMua, giaBan, loiNhuan;
    
    public MatHang(int n, String ten, String dvTinh, int giaMua, int giaBan) {
        this.ma = "MH0" + String.format("%02d", n);
        this.ten = ten;
        this.dvTinh = dvTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.loiNhuan = this.giaBan - this.giaMua;
    }
    
    @Override
    public int compareTo(MatHang o) {
        if(this.loiNhuan != o.loiNhuan) {
            return o.loiNhuan - this.loiNhuan;
        } else {
            return this.ma.compareTo(o.ma);
        }
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + dvTinh + " " + giaMua + " " + giaBan + " " + loiNhuan;
    }
    
}
