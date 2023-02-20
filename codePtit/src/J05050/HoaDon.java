/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05050;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maKH;
    private int hs, csC, csM;
    private long tien, phuTroi, tong;
    
    public HoaDon(int i, String SD, int csC, int csM) {
        this.maKH = "KH" + String.format("%02d", i);
        this.hs = heSo(SD);
        this.tien = (csM - csC) * hs * 550;
        phuTroi(csC, csM);
        this.tong = tien + phuTroi;
    }

    private int heSo(String SD) {
        switch(SD) {
            case "KD":
                return 3;
            case "NN":
                return 5;
            case "TT":
                return 4;
            case "CN":
                return 2;
        }
        return 0;
    }

    private void phuTroi(int csC, int csM) {
        int d = csM - csC;
        if(d > 100) {
            this.phuTroi = tien;
        }else if(d >= 50) {
            this.phuTroi = (long)Math.round((double)tien * 35 / 100);
        }else {
            this.phuTroi = 0;
        }
    }
    
    @Override
    public String toString() {
        return maKH + " " + hs + " " + tien + " " + phuTroi + " " + tong;
    }
}
