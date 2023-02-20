/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */

import java.awt.geom.Rectangle2D;


public class DanPhao {

    private Rectangle2D.Float hitbox;
    private int huong;
    private boolean trangThaiHoatDong = true;

    public DanPhao(int x, int y, int huong) {
        int buX = (int) (-3 * 1.5f);
        int buY = (int) (5 * 1.5f);

        if (huong == 1) {
            buX = (int) (29 * 1.5f);
        }

        hitbox = new Rectangle2D.Float(x + buX, y + buY, 22, 22);
        this.huong = huong;
    }

    public void capNhatViTri() {
        hitbox.x += huong * 0.75;
    }

    public void setViTri(int x, int y) {
        hitbox.x = x;
        hitbox.y = y;
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    public void setTrangThaiHoatDong(boolean trangThaiHoatDong) {
        this.trangThaiHoatDong = trangThaiHoatDong;
    }

    public boolean isTrangThaiHoatDong() {
        return trangThaiHoatDong;
    }

}
