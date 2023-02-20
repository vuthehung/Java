/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05033;

/**
 *
 * @author Admin
 */
public class ThoiGian implements Comparable<ThoiGian>{
    private int gio, phut, giay;
    
    public ThoiGian(int gio, int phut, int giay) {
        this.gio = gio;
        this.phut = phut;
        this.giay = giay;
    }

    @Override
    public int compareTo(ThoiGian o) {
        if(this.gio != o.gio) {
            return this.gio - o.gio;
        } else if(this.phut != o.phut) {
            return this.phut - o.phut;
        }
        return this.giay - o.giay;
    }
    
    @Override
    public String toString() {
        return gio + " " + phut + " " + giay;
    }
}
