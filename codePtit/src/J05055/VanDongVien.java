/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05055;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 *
 * @author Admin
 */
public class VanDongVien implements Comparable<VanDongVien> {

    private String ma, ten;
    private int stt;
    private long thoigian, uutien, ketqua;
    private LocalDate ns;
    private LocalTime start, end;

    public VanDongVien(int i,String ten, String ns, String start, String end){
        this.ma = "VDV" + String.format("%02d", i);
        this.ten = ten;
        this.ns = LocalDate.parse(ns, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.start = LocalTime.parse(start, DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.end = LocalTime.parse(end, DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.uutien = calcuutien();
        this.thoigian = ChronoUnit.SECONDS.between(this.start, this.end);
        this.ketqua = this.thoigian - this.uutien;
    }

    private long calcuutien() {
        if (2021 - this.ns.getYear() >= 32) {
            return 3;
        } else if (2021 - this.ns.getYear() >= 25) {
            return 2;
        } else if (2021 - this.ns.getYear() >= 18) {
            return 1;
        } else {
            return 0;
        }
    }

    public long getKetqua() {
        return ketqua;
    }

    public void setSTT(int i) {
        this.stt = i;
    }

    @Override
    public int compareTo(VanDongVien x) {
        if (this.ketqua > x.ketqua) {
            return 1;
        } else if (this.ketqua < x.ketqua) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s %02d:%02d:%02d %02d:%02d:%02d %02d:%02d:%02d %d", ma, this.ten, this.thoigian / 3600, (this.thoigian / 60) % 60, this.thoigian % 60, this.uutien / 3600, (this.uutien / 60) % 60, this.uutien % 60, this.ketqua / 3600, (this.ketqua / 60) % 60, this.ketqua % 60, this.stt);
    }
}
