/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */

public class LoThuoc extends PhuongThucChung {

    private float danhDauKhoangCachDiChuyen;
    private int khoangCachDiChuyenToiDa = 15; 
    private int huongDiChuyen = 1;

    public LoThuoc(int x, int y, int loaiThuoc) {
        super(x, y, loaiThuoc);
        thucHienHoatAnh = true;

        khoiTaoHitbox(7, 14);

        buX = (int) (3 * 1.5f);
        buY = (int) (2 * 1.5f);
    }

    public void capNhat() {
        capNhatHoatAnh();
        capNhatHieuUng();
    }

    //hiệu ứng lọ thuốc di chuyển lên xuống
    private void capNhatHieuUng() {
        danhDauKhoangCachDiChuyen += (0.075f * 1.5f * huongDiChuyen);

        if (danhDauKhoangCachDiChuyen >= khoangCachDiChuyenToiDa) {
            //hướng xuống
            huongDiChuyen = -1;
        } else if (danhDauKhoangCachDiChuyen < 0) {
            //hướng lên
            huongDiChuyen = 1;
        }

        hitbox.y = y + danhDauKhoangCachDiChuyen;
    }
}
