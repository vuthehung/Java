/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */

public class Bay extends PhuongThucChung {

    public Bay(int x, int y, int loaiVatThe) {
        super(x, y, loaiVatThe);
        khoiTaoHitbox(32, 16);
        buX = 0;
        buY = (int) (1.5f * 16);
        hitbox.y += buY;
    }
}
