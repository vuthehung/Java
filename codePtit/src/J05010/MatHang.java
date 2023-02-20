/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05010;

/**
 *
 * @author Admin
 */
public class MatHang implements Comparable<MatHang>{
    private String ma, ten, nhom;
    private float giaBan, giaMua, loiNhuan;
    
    public MatHang(int i, String ten, String nhom, float giaBan, float giaMua) {
        this.ma = Integer.toString(i);
        this.ten = ten;
        this.nhom = nhom;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.loiNhuan = giaBan - giaMua;
    }

    @Override
    public int compareTo(MatHang o) {
        return (int) (o.loiNhuan - this.loiNhuan);
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + nhom + " " + String.format("%.2f", loiNhuan);
    }
}
