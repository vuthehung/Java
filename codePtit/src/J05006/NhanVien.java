/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05006;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String ma, ten, gt, ns, dc, mt, nkhd;
    
    public NhanVien(int n, String ten, String gt, String ns, String dc, String mt, String nkhd) {
        this.ma = "000" + String.format("%02d", n);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.mt = mt;
        this.nkhd = nkhd;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mt + " " + nkhd;
    }
}
