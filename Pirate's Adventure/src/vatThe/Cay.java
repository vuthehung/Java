/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */


public class Cay {

    private int x, y, loaiCay, aniI, aniT;

    public Cay(int x, int y, int loaiCay) {
        this.x = x;
        this.y = y;
        this.loaiCay = loaiCay;
    }

    //cập nhật chuyển động của cây
    public void capNhat() {
        aniT++;
        if (aniT == 25) {
            aniT = 0;
            aniI++;
            if (aniI == 4) {
                aniI= 0;
            }
        }
    }

    public int getAniI() {
        return aniI;
    }

    public void setAniI(int aniI) {
        this.aniI = aniI;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLoaiCay() {
        return loaiCay;
    }

    public void setLoaiCay(int loaiCay) {
        this.loaiCay = loaiCay;
    }
}
