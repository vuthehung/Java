/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05007;

/**
 *
 * @author Admin
 */
import java.text.*;
import java.util.Date;
public class NhanVien implements Comparable<NhanVien>{
    private String ma, ten, gt, dc, mt, nkhd;
    private Date ns;
    
    public NhanVien(int n, String ten, String gt, String ns, String dc, String mt, String nkhd) throws ParseException {
        this.ma = "000" + String.format("%02d", n);
        this.ten = ten;
        this.gt = gt;
        this.ns = new SimpleDateFormat("dd/MM/yyyy").parse(ns);
        this.dc = dc;
        this.mt = mt;
        this.nkhd = nkhd;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + gt + " " + new SimpleDateFormat("dd/MM/yyyy").format(ns) + " " + dc + " " + mt + " " + nkhd;
    }

    @Override
    public int compareTo(NhanVien o) {
        return (int) (this.ns.getTime() / (24 * 60 * 60 * 1000) - o.ns.getTime() / (24 * 60 * 60 * 1000));
    }
}
