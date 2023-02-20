/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05009;

/**
 *
 * @author Admin
 */
public class ThiSinh implements Comparable<ThiSinh>{
    private String ma, ten, ns;
    float diem1;
    private float diem2, diem3, tong;
    
    public ThiSinh(int n, String ten, String ns, float diem1, float diem2, float diem3) {
        this.ma = Integer.toString(n);
        this.ten = ten;
        this.ns = ns;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.tong = diem1 + diem2 + diem3;
    }
    public float getTong() {
        return tong;
    }
    @Override
    public int compareTo(ThiSinh o) {
        if(this.tong != o.tong) 
            return (int) (o.tong - this.tong);
        return this.ma.compareTo(o.ma);
    }
    @Override
    public String toString() {
        return ma + " " + ten + " " + ns + " " + tong;
    }
}
