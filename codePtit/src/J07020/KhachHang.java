/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J07020;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String ma, ten, gt, dc;
    private Date ns;
    
    public KhachHang(int i, String ten, String gt, String ns, String dc) throws ParseException {
        this.ma = "KH" + String.format("%03d", i);
        this.ten = ten;
        this.gt = gt;
        this.ns = new SimpleDateFormat("dd/MM/yyyy").parse(ns);
        this.dc = dc;
    }
    
    public String getMa() {
        return ma;
    }
    public String getTen() {
        return ten;
    }
    
    public String getDc() {
        return dc;
    }
}
