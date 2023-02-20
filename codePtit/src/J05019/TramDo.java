/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05019;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Admin
 */
public class TramDo {
    private String ma, ten;
    private int luongMua, tG;
    
    public TramDo(int i, String ten, String bd, String kt, int luongMua) {
        this.ma = "T" + String.format("%02d", i);
        this.ten = ten;
        this.luongMua = luongMua;
        this.tG = (int) ChronoUnit.MINUTES.between(LocalTime.parse(bd, DateTimeFormatter.ofPattern("HH:mm")), LocalTime.parse(kt, DateTimeFormatter.ofPattern("HH:mm")));
    }
    
    public void addData(String bd, String kt, int luongMua) {
        this.tG += (int) ChronoUnit.MINUTES.between(LocalTime.parse(bd, DateTimeFormatter.ofPattern("HH:mm")), LocalTime.parse(kt, DateTimeFormatter.ofPattern("HH:mm")));
        this.luongMua += luongMua;
    }
    
    @Override
    public String toString() {
        return ma + " " + ten + " " + String.format("%.2f", (luongMua * 60f / tG));
    }
}
