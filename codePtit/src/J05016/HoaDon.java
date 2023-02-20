/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05016;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maKH, ten, phong;
    private int dv, thanhtien, ngayO;
    private LocalDate nden, ndi;
    
    public HoaDon(int i, String ten, String phong, String nden, String ndi, int dv) {
        this.maKH = "KH" + String.format("%02d", i);
        this.ten = ten;
        this.phong = phong;
        this.nden = LocalDate.parse(nden, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.ndi = LocalDate.parse(ndi, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.ngayO = (int)ChronoUnit.DAYS.between(this.nden, this.ndi) + 1;
        this.dv = dv;
    }
    
    @Override
    public String toString() {
        return maKH + " " + ngayO;
    }
}
