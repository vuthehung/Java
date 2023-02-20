/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */


public class Phao extends PhuongThucChung {

    private int tileY;

    public Phao(int x, int y, int objType) {
        super(x, y, objType);
        tileY = y / 48;
        khoiTaoHitbox(40, 26);
//		hitbox.x -= (int) (1 * Game.SCALE);
        hitbox.y += (int) (6 * 1.5f);
    }

    public void capNhat() {
        if (thucHienHoatAnh) {
            capNhatHoatAnh();
        }
    }

    public int getTileY() {
        return tileY;
    }

}
