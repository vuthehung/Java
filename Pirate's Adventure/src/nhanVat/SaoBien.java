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
import static phuongThucTaiSuDung.HangSo.Huong.*;

import trangThai.Playing;

public class SaoBien extends QuaiVat {

    private boolean lan = true;
    private int danhDauLanCuoiCungGaySatThuong;
    private int danhDauTrangThaiChoSauKhiLan;
    private int danhDauThoiGianLan;

    public SaoBien(float x, float y) {
        super(x, y, 52, 45, SaoBien);
        khoiTaoHitbox(17, 21);
    }

    public void capNhat(int[][] chatLieu, Playing playing) {
        capNhatHanhDong(chatLieu, playing);
        capNhatHoatAnh();
    }

    private void capNhatHanhDong(int[][] chatLieu, Playing playing) {
        if (capNhatLanDau) {
            kiemTraCapNhatLanDau(chatLieu);
        }

        if (trenKhong) {
            kiemTraTrenKhong(chatLieu, playing);
        } else {
            switch (trangThai) {
                case Dung:
                    lan = true;
                    if (danhDauTrangThaiChoSauKhiLan == 120) {
                        if (LaMatDat(hitbox, chatLieu)) {
                            trangThaiMoi(DiChuyen);
                        } else {
                            trenKhong = true;
                        }
                        danhDauTrangThaiChoSauKhiLan = 0;
                        danhDauLanCuoiCungGaySatThuong = 60;
                    } else {
                        danhDauTrangThaiChoSauKhiLan++;
                    }
                    break;
                case DiChuyen:
                    if (tamNhin(chatLieu, playing.getCuopBien())) {
                        trangThaiMoi(TanCong);
                        doiHuongDi(playing.getCuopBien());
                    }
                    diChuyen(chatLieu, playing);
                    break;
                case TanCong:
                    if (lan) {
                        if (aniI >= 3) {
                            lan = false;
                        }
                    } else {
                        diChuyen(chatLieu, playing);
                        kiemTraSatThuongGayRaChoCuopBien(playing.getCuopBien());
                        kiemTraKetThucLan(playing);
                    }
                    break;
                case BiTanCong:
                    if (aniI <= ViTriHinhAnh(loaiQV, trangThai) - 2) {
                        dayLui(huongBiDayLui, chatLieu, 2f);
                    }
                    capNhatTocDoXuongKhiBiTanCong();
                    danhDauTrangThaiChoSauKhiLan = 120;

                    break;
            }
        }
    }

    //Ki???m tra sao bi???n c?? t???n c??ng c?????p bi???n ko? n???u c?? c?????p bi???n m???t m??u
    private void kiemTraSatThuongGayRaChoCuopBien(CuopBien cb) {
        if (hitbox.intersects(cb.getHitbox())) {
            if (danhDauLanCuoiCungGaySatThuong == 60) {
                danhDauLanCuoiCungGaySatThuong = 0;
                cb.capNhatMau(-SatThuong(loaiQV), this);
            } else {
                danhDauLanCuoiCungGaySatThuong++;
            }
        }
    }

    //?????i h?????ng di chuy???n n???u c?????p bi???n trong t???m nh??n
    private void doiHuongDi(CuopBien cb) {
        if (cb.getHitbox().x > hitbox.x) {
            huongDi = Phai;
        } else {
            huongDi = Trai;
        }

    }
    //ki???m tra tr???ng th??i di chuy???n: h?????ng ??i, t???n c??ng
    protected void diChuyen(int[][] chatLieu, Playing playing) {
        float tocDo = 0;

        if (huongDi == Trai) {
            tocDo = -tocDoDiChuyen;
        } else {
            tocDo = tocDoDiChuyen;
        }

        if (trangThai == TanCong) {
            tocDo *= 2;
        }

        if (CoTheDiChuyenDen(hitbox.x + tocDo, hitbox.y, hitbox.width, hitbox.height, chatLieu)) {
            if (LaMatDat(hitbox, tocDo, chatLieu)) {
                hitbox.x += tocDo;
                return;
            }
        }

        if (trangThai == TanCong) {
            ketThucTrangThaiLan(playing);
            danhDauThoiGianLan = 0;
        }

        if (huongDi == Trai) {
            huongDi = Phai;
        } else {
            huongDi = Trai;
        }

    }

    //ki???m tra k???t th??c 1 l???n l??n
    //cho th???i gian l??n l?? 300
    private void kiemTraKetThucLan(Playing playing) {
        danhDauThoiGianLan++;
        if (danhDauThoiGianLan == 300) {
            ketThucTrangThaiLan(playing);
            danhDauThoiGianLan = 0;
        }
    }

    //k???t th??c h??nh ?????ng l??n
    private void ketThucTrangThaiLan(Playing playing) {
        trangThaiMoi(Dung);
    }

}
