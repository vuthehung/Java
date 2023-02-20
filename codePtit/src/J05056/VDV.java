/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05056;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Admin
 */
public class VDV implements Comparable<VDV>{
    private String ma, ten;
    private int xh;
    private long tG, uuTien, thanhTich;
    private LocalDate ns;
    private LocalTime bd, kt;
    
    public VDV(int i, String ten, String ns, String bd, String kt) {
        this.ma = "VDV" + String.format("%02d", i);
        this.ten = ten;
        this.ns = LocalDate.parse(ns, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.bd = LocalTime.parse(bd, DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.kt = LocalTime.parse(kt, DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.tG = ChronoUnit.SECONDS.between(this.bd, this.kt);
        this.uuTien = tinhUuTien();
        this.thanhTich = this.tG - this.uuTien;
    }

    private long tinhUuTien() {
        if(2021 - this.ns.getYear() >= 32) {
            return 3;
        }else if(2021 - this.ns.getYear() >= 25) {
            return 2;
        }else if(2021 - this.ns.getYear() >= 18) {
            return 1;
        }else {
            return 0;
        }
    }
    
    public void setXH(int i) {
        this.xh = i;
    }
    
    public long getThanhTich() {
        return thanhTich;
    }
    
    @Override
    public int compareTo(VDV o) {
        if(this.thanhTich > o.thanhTich) return 1;
        else if(this.thanhTich < o.thanhTich) return -1;
        return 0;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %02d:%02d:%02d %02d:%02d:%02d %02d:%02d:%02d %d", ma, ten, tG / 3600, (tG / 60) % 60, tG % 60 , uuTien / 3600, (uuTien / 60) % 60, uuTien % 60, thanhTich / 3600, (thanhTich / 60) % 60, thanhTich % 60, xh);
    }
}
