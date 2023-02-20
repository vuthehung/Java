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

public class ThungChua extends PhuongThucChung {

    public ThungChua(int x, int y, int loaiVatThe) {
        super(x, y, loaiVatThe);
        taoHitbox();
    }

    private void taoHitbox() {
        if (loaiVatThe == Hop) {
            khoiTaoHitbox(25, 18);

            buX = (int) (7 * 1.5f);
            buY = (int) (12 * 1.5f);

        } else {
            khoiTaoHitbox(23, 25);
            buX = (int) (8 * 1.5f);
            buY = (int) (5 * 1.5f);
        }

        hitbox.y += buY + (int) (1.5f * 2);
        hitbox.x += buX / 2;
    }

    public void update() {
        if (thucHienHoatAnh) {
            capNhatHoatAnh();
        }
    }
}
