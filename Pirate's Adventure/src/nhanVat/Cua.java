/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanVat;
/**
 *
 * @author Admin
 */

import static phuongThucTaiSuDung.HangSo.QuaiVat.*;
import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;

import trangThai.Playing;

public class Cua extends QuaiVat {

    public Cua(float x, float y) {
        super(x, y, 112, 48, Cua);
        khoiTaoHitbox(22, 19);
        khoiTaoAttackBox(82, 19, 30);
    }

    public void capNhat(int[][] chatLieu, Playing playing) {
        capNhatHanhVi(chatLieu, playing);
        capNhatHoatAnh();
        capNhatAttackBox();
    }

    private void capNhatHanhVi(int[][] chatLieu, Playing playing) {
        if (capNhatLanDau) {
            kiemTraCapNhatLanDau(chatLieu);
        }

        if (trenKhong) {
            kiemTraTrenKhong(chatLieu, playing);
        } else {
            switch (trangThai) {
                case Dung:
                    if (LaMatDat(hitbox, chatLieu)) {
                        trangThaiMoi(DiChuyen);
                    } else {
                        trenKhong = true;
                    }
                    break;
                case DiChuyen:
                    if (tamNhin(chatLieu, playing.getCuopBien())) {
                        quayVeHuongCuopBien(playing.getCuopBien());
                        if (trongTamDanh(playing.getCuopBien())) {
                            trangThaiMoi(TanCong);
                        }
                    }
                    diChuyen(chatLieu);

                    break;
                case TanCong:
                    if (aniI== 0) {
                        kiemTraTanCong = false;
                    }
                    if (aniI== 3 && !kiemTraTanCong) {
                        cuopBienBiTanCong(attackBox, playing.getCuopBien());
                    }
                    break;
                case BiTanCong:
                    if (aniI<= ViTriHinhAnh(loaiQV, trangThai) - 2) {
                        dayLui(huongBiDayLui, chatLieu, 2f);
                    }
                    capNhatTocDoXuongKhiBiTanCong();
                    break;
            }
        }
    }

}
