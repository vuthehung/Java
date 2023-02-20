/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */

import static phuongThucTaiSuDung.HangSo.viTriCacVatThe.*;

import java.awt.geom.Rectangle2D;


public class PhuongThucChung {

    protected int x, y, loaiVatThe;
    protected Rectangle2D.Float hitbox;
    protected boolean thucHienHoatAnh, hoatDong = true;
    protected int aniT, aniI;
    protected int buX, buY;

    public PhuongThucChung(int x, int y, int loaiVatThe) {
        this.x = x;
        this.y = y;
        this.loaiVatThe = loaiVatThe;
    }

    protected void capNhatHoatAnh() {
        aniT++;
        if (aniT == 25) {
            aniT = 0;
            aniI++;
            if (aniI >= (loaiVatThe)) {
                aniI = 0;
                if (loaiVatThe == Thung || loaiVatThe == Hop) {
                    thucHienHoatAnh = false;
                    hoatDong = false;
                } else if (loaiVatThe == PhaoTrai || loaiVatThe == PhaoPhai) {
                    thucHienHoatAnh = false;
                }
            }
        }
    }

    public void datLaiThamSo() {
        aniI = 0;
        aniT = 0;
        hoatDong = true;

        if (loaiVatThe == Thung || loaiVatThe == Hop || loaiVatThe == PhaoTrai || loaiVatThe == PhaoPhai) {
            thucHienHoatAnh = false;
        } else {
            thucHienHoatAnh = true;
        }
    }

    protected void khoiTaoHitbox(int width, int height) {
        hitbox = new Rectangle2D.Float(x, y, (int) (width * 1.5f), (int) (height * 1.5f));
    }

//    public void veHitbox(Graphics g, int xLvlOffset) {
//        g.setColor(Color.PINK);
//        g.drawRect((int) hitbox.x - xLvlOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
//    }

    public int getLoaiVatThe() {
        return loaiVatThe;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public boolean isHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(boolean hoatDong) {
        this.hoatDong = hoatDong;
    }

    public void setHoatAnh(boolean thucHienHoatAnh) {
        this.thucHienHoatAnh = thucHienHoatAnh;
    }

    public int getBuX() {
        return buX;
    }

    public int getBuY() {
        return buY;
    }

    public int getAniI() {
        return aniI;
    }

    public int getAniT() {
        return aniT;
    }

}
